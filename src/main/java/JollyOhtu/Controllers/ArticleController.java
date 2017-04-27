/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JollyOhtu.Controllers;

import JollyOhtu.Objects.Article;
import JollyOhtu.Repository.ArticleRepository;
import JollyOhtu.Services.AuthenticationService;
import java.util.List;
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
        Boolean callIdRepeats = false;
        if(article.initCallId()){
            callIdRepeats = AuthenticationService.validateArticleCallId(article, artRepo);
        }
        List<String> errors = AuthenticationService.validateAddArticle(article, artRepo);
        if (callIdRepeats){
            errors.add("There was an error with automatic ID generation, please enter one manually.");
        }
        if (errors.isEmpty()) {
            if (artRepo.save(article) != null) {
                model.addAttribute("success", "Reference was saved successfully!");
                model.addAttribute("article", new Article());
            } else {
                errors.add("There was an error saving the reference. Reference not saved");
            }
        }
        model.addAttribute("errors", errors);
        return "add_article";
    }

    //HUOM. vain testausta varten
//    @RequestMapping(value = "/delete_articles", method = GET)
//    public String articleDeleteAll() {
//        artRepo.deleteAll();
//        return "index";
//    }


}
