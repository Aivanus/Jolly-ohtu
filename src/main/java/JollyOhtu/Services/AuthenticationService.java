/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JollyOhtu.Services;

import JollyOhtu.Objects.Article;
import JollyOhtu.Objects.Book;
import JollyOhtu.Objects.Inproceedings;
import JollyOhtu.Repository.ArticleRepository;
import JollyOhtu.Repository.BookRepository;
import JollyOhtu.Repository.InproceedingsRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author as
 */
public class AuthenticationService {
    
    
    public static List<String> validateAddBook(Book book, BookRepository books){
        
        List<String> errors = new ArrayList<String>();
        if (!book.mandatoryFieldsAreFilled()){
            errors.add(new String("You must fill in the fields marked by *"));
        }
        if (book.bookHasInvalidInfo()) {
            errors.add(new String("Invalid input. Check your input."));
        }
        if(books.copyExists(book)){
            errors.add(new String("The book reference already exists."));
        }
        return errors;
    }
    
    public static List<String> validateAddArticle(Article article, ArticleRepository articles){
        List<String> errors = new ArrayList<String>();
         if (article.mandatoryFieldsArentFilled()) {
            errors.add(new String("You must fill in the fields marked by *"));
        } if (article.articleHasInvalidInfo()) {
            errors.add(new String("Invalid input. Check your input."));
        } if (articles.copyExists(article)) {
            errors.add(new String("The article reference already exists."));
        }
        return errors;
    }
    
    public static List<String> validateAddInproceedings(Inproceedings inpro, InproceedingsRepository inpros){
        List<String> errors = new ArrayList<String>();
        if (inpro.mandatoryFieldsArentFilled()) {
            errors.add(new String("You must fill in the fields marked by *"));
        } 
        if (inpro.inproceedingsHasInvalidInfo()) {
            errors.add(new String("Invalid input. Check your input."));
        } 
        if (inpros.copyExists(inpro)) {
            errors.add(new String("The inproceedings reference already exists."));
        } 
        return errors;
    }
}
