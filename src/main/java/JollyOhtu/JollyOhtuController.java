package JollyOhtu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by topi on 31.3.2017.
 */

@Controller
@RequestMapping("/index")
public class JollyOhtuController{
    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody String sayHello(@RequestParam(value="name", required = false)String name) {
        return "Hello JollyOhtu gradle";
    }


}
