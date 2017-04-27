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

    public static List<String> validateAddBook(Book book, BookRepository books) {

        List<String> errors = new ArrayList<>();
        if (!book.mandatoryFieldsAreFilled()) {
            errors.add("You must fill in the fields marked by *");
        }
        if (book.bookHasInvalidInfo()) {
            errors.add("Invalid input. Check your input.");
        }
        if (books.copyExists(book)) {
            errors.add("The book reference already exists with the Call Id: "+ books.findCallId(book).get(0)+ ".");
        }
        if (books.callIdExists1(book) ){//|| books.callIdExists2(book) || books.callIdExists3(book)) {
            errors.add("That call Id already exists, choose another one.");
        }
        return errors;
    }

    public static List<String> validateAddArticle(Article article, ArticleRepository articles) {
        List<String> errors = new ArrayList<>();
        if (article.mandatoryFieldsArentFilled()) {
            errors.add("You must fill in the fields marked by *");
        }
        if (article.articleHasInvalidInfo()) {
            errors.add("Invalid input. Check your input.");
        }
        if (articles.copyExists(article)) {
            errors.add(("The article reference already exists with the Call Id: " + articles.findCallId(article).get(0) + "."));
        }
        if (articles.callIdExists1(article) ){//|| articles.callIdExists2(article) || articles.callIdExists3(article)) {
            errors.add("That call Id already exists, choose another one.");
        }
        return errors;
    }

    public static List<String> validateAddInproceedings(Inproceedings inpro, InproceedingsRepository inpros) {
        List<String> errors = new ArrayList<>();
        if (inpro.mandatoryFieldsArentFilled()) {
            errors.add("You must fill in the fields marked by *");
        }
        if (inpro.inproceedingsHasInvalidInfo()) {
            errors.add("Invalid input. Check your input.");
        }
        if (inpros.copyExists(inpro)) {
            errors.add("The inproceedings reference already exists with the Call Id: " + inpros.findCallId(inpro).get(0)+".");
        }
        if (inpros.callIdExists1(inpro) ){//|| inpros.callIdExists1(inpro) || inpros.callIdExists1(inpro)) {
            errors.add("That call Id already exists, choose another one.");
        }
        return errors;
    }
    
    public static List<String> validateDeleteBooks(ArrayList<String> ids){
        List<String> errors = new ArrayList<>();
        if(ids==null){
            errors.add("Please check the books you want to delete.");
        }
        return errors;
    }
    
    public static List<String> validateDeleteArticles(ArrayList<String> ids){
        List<String> errors = new ArrayList<>();
        if(ids==null){
            errors.add("Please check the articles you want to delete.");
        }
        return errors;
    }
    
    public static List<String> validateDeleteInproceedings(ArrayList<String> ids){
        List<String> errors = new ArrayList<>();
        if(ids==null){
            errors.add("Please check the inproceedings you want to delete.");
        }
        return errors;
    }
    
    

}
