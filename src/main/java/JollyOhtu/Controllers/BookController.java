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
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

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
        Book tallennettu = repository.save(book);
        if (tallennettu != null) {
            model.addAttribute("success", new String("Reference was saved succesfully!"));
            model.addAttribute("book", new Book());
        } else {
            model.addAttribute("error", new String("An error occurred. Reference was not saved."));
        }
        return "add_book";
    }

    //HUOM. vain testausta varten
    @RequestMapping(value = "/delete_books")
    public String bookDeleteAll() {
        repository.deleteAll();
        return "index";
    }

}
