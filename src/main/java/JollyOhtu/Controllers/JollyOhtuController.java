package JollyOhtu.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by topi on 31.3.2017.
 */

@Controller
public class JollyOhtuController{
    @RequestMapping("/")
    public String index(){
        return("index");
    }
    
   


}
