package JollyOhtu.Controllers;

import JollyOhtu.Repository.ArticleRepository;
import JollyOhtu.Repository.BookRepository;
import JollyOhtu.Repository.InproceedingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ReferenceController {
    @Autowired
    private ArticleRepository artRepo;
    @Autowired
    private BookRepository bookRepo;
    @Autowired
    private InproceedingsRepository inproRepo;
    private List<Object> references = new ArrayList<>();

    @RequestMapping(value = "/list_references", method = GET)
    public ModelAndView listReferences() {
        ModelAndView mav = new ModelAndView("list_references");
        mav.addObject("books", bookRepo.findAll());
        mav.addObject("articles", artRepo.findAll());
        mav.addObject("inproceedings", inproRepo.findAll());
        
        return mav;
    }
    
    @RequestMapping(value = "/search", method = GET)
    public ModelAndView searchReferences(@RequestParam("word") String searchedWord){
        ModelAndView mav = new ModelAndView("search");
        mav.addObject("books", bookRepo.findWord(searchedWord));
        mav.addObject("articles", artRepo.findWord(searchedWord));
        mav.addObject("inproceedings", inproRepo.findWord(searchedWord));
        
        return mav;

    }
    

    
}
