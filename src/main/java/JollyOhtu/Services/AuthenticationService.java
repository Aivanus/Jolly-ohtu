/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JollyOhtu.Services;

import JollyOhtu.Objects.Book;
import JollyOhtu.Repository.BookRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author as
 */
public class AuthenticationService {
    
    
    public  List<String> validateAddBook(Book book, BookRepository books){
        
        List<String> errors = new ArrayList<String>();
        if (!book.mandatoryFieldsAreFilled()){
            errors.add(new String("You must fill in the fields marked by *"));
        }
        if(books.copyExists(book)){
            errors.add(new String("Reference already exists!"));
        }
        return errors;
    }
}
