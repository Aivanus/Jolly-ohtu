package JollyOhtu.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by topi on 31.3.2017.
 */

@Controller
public class JollyOhtuController{
    @RequestMapping("/esim")
    public String sayHello(@RequestParam(value="name", required = false, defaultValue="world")String name, Model model) {
        model.addAttribute("name", name);
        return "esim";
    }
    
    @RequestMapping("/")
    public String index(){
        return("index");
    }
    
   


}
