/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JollyOhtu.Controllers;

import JollyOhtu.Objects.Article;
import JollyOhtu.Repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 *
 * @author ritakosk
 */
@Controller
public class ArticleController {

    @Autowired
    private ArticleRepository artRepo;

    @RequestMapping(value = "/add_article", method = GET)
    public String articleForm(Model model) {
        model.addAttribute("article", new Article());
        return "add_article";
    }

    @RequestMapping(value = "/add_article", method = POST)
    public String articleSubmit(@ModelAttribute Article article, Model model) {

        if (article.mandatoryFieldsArentFilled()) {
            model.addAttribute("errors", new String("You must fill in the fields marked by *"));
        } else if (article.articleHasInvalidInfo()) {
            model.addAttribute("errors", new String("Invalid input. Check your input."));
        } else if (articleIsADuplicate(article, artRepo)) {
            model.addAttribute("errors", new String("The article reference already exists."));
        } else if (artRepo.save(article) != null) {
            model.addAttribute("success", new String("Reference was saved succesfully!"));
            model.addAttribute("article", new Article());
        } else {
            model.addAttribute("errors", new String("There was an error saving"
                    + " the reference. Reference not saved"));
        }
//        System.out.println(artRepo.count()); //for testing
        return "add_article";
    }

    //HUOM. vain testausta varten
    @RequestMapping(value = "/delete_articles", method = GET)
    public String articleDeleteAll() {
        artRepo.deleteAll();
        return "index";
    }

    private boolean articleIsADuplicate(Article article, ArticleRepository artRepo) {
        return artRepo.findByAuthorAndTitleAndJournalAndYearAndVolumeAndNumberAndPagesAndMonthAndNote(article.getAuthor(), article.getTitle(),
                article.getJournal(), article.getYear(), article.getVolume(),
                article.getNumber(), article.getPages(), article.getMonth(),
                article.getNote()).size() > 0;

    }

}
