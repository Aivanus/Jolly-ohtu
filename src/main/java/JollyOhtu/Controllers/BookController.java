/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JollyOhtu.Controllers;

/**
 *
 * @author alsu
 */
import JollyOhtu.Objects.Book;
import JollyOhtu.Repository.BookRepository;
import JollyOhtu.Services.AuthenticationService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {

    @Autowired
    private BookRepository repository;

    @RequestMapping(value = "/add_book", method = GET)
    public String bookForm(Model model) {
        model.addAttribute("book", new Book());
        return "add_book";
    }

    @RequestMapping(value = "/add_book", method = POST)
    public String bookSubmit(@ModelAttribute Book book, Model model) {



        Boolean callIdRepeats = false;
        if(book.initCallId()){
            callIdRepeats = AuthenticationService.validateBookCallId(book, repository);
        }

        List<String> errors = AuthenticationService.validateAddBook(book, repository);
        if (callIdRepeats){
            errors.add("There was an error with automatic ID generation, please enter one manually.");
        }
        if (errors.isEmpty()) {
            Book tallennettu = repository.save(book);
            if (tallennettu != null) {
                model.addAttribute("success", "Reference was saved successfully!");
                model.addAttribute("book", new Book());
            } else {

                

               errors.add("An error occurred. Reference was not saved.");
            }
        }
        model.addAttribute("errors", errors);

        return "add_book";
    }

    @RequestMapping(value = "/delete_books", method = POST)
    public String bookDeleteChecked(@RequestParam(value = "del_books", 
            required=false) ArrayList<String> del, RedirectAttributes redirect) {
        
        List<String> errors = AuthenticationService.validateDeleteBooks(del);
        if (errors.isEmpty()) {
            for (String id : del) {
                this.repository.delete(Long.parseLong(id));
            }
            if(del.size()==1){
                redirect.addFlashAttribute("success", "One book reference was deleted succesfully.");
            }else{
                redirect.addFlashAttribute("success", del.size()+" book references were deleted succesfully.");
            }
        }
        redirect.addFlashAttribute("errors", errors);

        return "redirect:/list_references";
    }

    

}
