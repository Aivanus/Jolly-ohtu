package JollyOhtu.Controllers;

import JollyOhtu.Repository.ArticleRepository;
import JollyOhtu.Repository.BookRepository;
import JollyOhtu.Repository.InproceedingsRepository;
import JollyOhtu.Services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @RequestMapping(value = "/handle_references", method = POST, params = "action=delete")
    public String deleteReferences(@RequestParam(value = "del_inproceedings", required = false) ArrayList<String> inpros,
            @RequestParam(value = "del_books", required = false) ArrayList<String> books,
            @RequestParam(value = "del_articles", required = false) ArrayList<String> articles,
            @RequestParam(value = "action", required = true) String action,
            RedirectAttributes redirect) throws Exception {

        List<String> bookErrors = AuthenticationService.validateDeleteBooks(books);
        List<String> inproErrors = AuthenticationService.validateDeleteInproceedings(inpros);
        List<String> articleErrors = AuthenticationService.validateDeleteArticles(articles);

        deleteFromDatabase(bookErrors, books, articleErrors, articles, inproErrors, inpros);

        if (books != null|| articles != null || inpros != null) {
            redirect.addFlashAttribute("success", "Selected references deleted succesfully.");
        }
        bookErrors.addAll(inproErrors);
        bookErrors.addAll(articleErrors);
        if (bookErrors.size() >= 3) {
            redirect.addFlashAttribute("errors", bookErrors);
        }
        return "redirect:/list_references";
    }

    private void deleteFromDatabase(List<String> bookErrors, ArrayList<String> books, List<String> articleErrors, ArrayList<String> articles, List<String> inproErrors, ArrayList<String> inpros) throws NumberFormatException {
        if (bookErrors.isEmpty()) {
            for (String id : books) {
                bookRepo.delete(Long.parseLong(id));
            }
        }

        if (articleErrors.isEmpty()) {
            for (String id : articles) {
                artRepo.delete(Long.parseLong(id));
            }
        }

        if (inproErrors.isEmpty()) {
            for (String id : inpros) {
                inproRepo.delete(Long.parseLong(id));
            }
        }
    }

    @RequestMapping(value = "handle_references", method = POST, params = "action=download")
    public ResponseEntity<String> loadFile(@RequestParam(value = "del_inproceedings", required = false) ArrayList<String> inpros,
            @RequestParam(value = "del_books", required = false) ArrayList<String> books,
            @RequestParam(value = "del_articles", required = false) ArrayList<String> articles,
            @RequestParam(value = "action", required = true) String action) throws Exception {
        
        return null;
    }
}
