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
            errors.add("The book reference already exists with the ID: " + books.findCallId(book).get(0) + ".");
        }
        if (book.initCallId()) {
            if (validateBookCallId(book, books)) {
                errors.add("There was an error with automatic ID generation, please enter one manually.");
            }
        }
        if (books.callIdExists1(book) || books.callIdExists2(book) || books.callIdExists3(book)) {
            errors.add("That Id already exists, choose another one.");
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
            errors.add(("The article reference already exists with the ID: " + articles.findCallId(article).get(0) + "."));
        }
        if (article.initCallId()) {
            if (validateArticleCallId(article, articles)) {
                errors.add("There was an error with automatic ID generation, please enter one manually.");
            }
        }
        if (articles.callIdExists1(article) || articles.callIdExists2(article) || articles.callIdExists3(article)) {
            errors.add("That Id already exists, choose another one.");
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
            errors.add("The inproceedings reference already exists with the ID: " + inpros.findCallId(inpro).get(0) + ".");
        }
        if (inpro.initCallId()) {
            if (validateInproceedingsCallId(inpro, inpros)) {
                errors.add("There was an error with automatic ID generation, please enter one manually.");
            }
        }
        if (inpros.callIdExists1(inpro) || inpros.callIdExists2(inpro) || inpros.callIdExists3(inpro)) {
            errors.add("That Id already exists, choose another one.");
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
    
    

    private static Boolean validateBookCallId(Book book, BookRepository books) {
        String callIdOrigin = book.getCallId();
        for (int i = 1; i <= 1000; i++) {
            if (books.callIdExists1(book) || books.callIdExists2(book) || books.callIdExists3(book)) {
                String help = callIdOrigin;
                help += "(" + i + ")";
                book.setCallId(help);
            } else {
                return false;
            }
        }
        return true;
    }

    private static Boolean validateArticleCallId(Article article, ArticleRepository articles) {
        String callIdOrigin = article.getCallId();
        for (int i = 1; i <= 1000; i++) {
            if (articles.callIdExists1(article) || articles.callIdExists2(article) || articles.callIdExists3(article)) {
                String help = callIdOrigin;
                help += "(" + i + ")";
                article.setCallId(help);
            } else {
                return false;
            }
        }
        return true;
    }

    private static Boolean validateInproceedingsCallId(Inproceedings inpro, InproceedingsRepository inpros) {
        String callIdOrigin = inpro.getCallId();
        for (int i = 1; i <= 1000; i++) {
            if (inpros.callIdExists1(inpro) || inpros.callIdExists2(inpro) || inpros.callIdExists3(inpro)) {
                String help = callIdOrigin;
                help += "(" + i + ")";
                inpro.setCallId(help);
            } else {
                return false;
            }
        }
        return true;
    }
}
