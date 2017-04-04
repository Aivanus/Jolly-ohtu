/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JollyOhtu.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 *
 * @author ritakosk
 */
@Controller
public class ArticleController {

    @RequestMapping(value = "/add_article", method = GET)
    public String addArticle() {
        return "add_article";
    }

}
