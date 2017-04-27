/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JollyOhtu.Controllers;

import JollyOhtu.Objects.Article;
import JollyOhtu.Repository.ArticleRepository;
import JollyOhtu.Services.AuthenticationService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

        List<String> errors = AuthenticationService.validateAddArticle(article, artRepo);
        if (errors.isEmpty()) {
            if (artRepo.save(article) != null) {
                model.addAttribute("success", new String("Reference was saved succesfully!"));
                model.addAttribute("article", new Article());
            } else {
                errors.add(new String("There was an error saving"
                        + " the reference. Reference not saved"));
            }
        }
        model.addAttribute("errors", errors);

//        System.out.println(artRepo.count()); //for testing
        return "add_article";
    }

    @RequestMapping(value = "/delete_articles", method = POST)
    public String bookDeleteChecked(@RequestParam(value="del_articles", required=false)ArrayList<String> del,
            RedirectAttributes redirect) {
          
        List<String> errors = AuthenticationService.validateDeleteArticles(del);
        if (errors.isEmpty()) {
            for (String id : del) {
                this.artRepo.delete(Long.parseLong(id));
            }
            if(del.size()==1){
                redirect.addFlashAttribute("success", "One article reference was deleted succesfully.");
            }else{
                redirect.addFlashAttribute("success", del.size()+" article references were deleted succesfully.");
            }
        }
        redirect.addFlashAttribute("errors", errors);
       return "redirect:/list_references";
    }


}
