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
        if (books.callIdExists1(book) || books.callIdExists2(book) || books.callIdExists3(book)) {
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
            errors.add(("The article reference already exists with the ID: " + articles.findCallId(article).get(0) + "."));
        }
        if (articles.callIdExists1(article) || articles.callIdExists2(article) || articles.callIdExists3(article)) {
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
            errors.add("The inproceedings reference already exists with the ID: " + inpros.findCallId(inpro).get(0) + ".");
        }
        if (inpros.callIdExists1(inpro) || inpros.callIdExists2(inpro) || inpros.callIdExists3(inpro)) {
            errors.add("That ID already exists, choose another one.");
        }
        return errors;
    }

    public static Boolean validateBookCallId(Book book, BookRepository books) {
        book.setCallIdOrigin(book.getCallId());
        for (int i = 1; i <= 1000; i++) {
            if (books.callIdExists1(book) || books.callIdExists2(book) || books.callIdExists3(book)) {
                String help = book.getCallIdOrigin();
                help += "(" + i + ")";
                book.setCallId(help);
            } else {
                return false;
            }
        }
        return true;
    }
    
    public static Boolean validateArticleCallId(Article article, ArticleRepository articles) {
        article.setCallIdOrigin(article.getCallId());
        for (int i = 1; i <= 1000; i++) {
            if (articles.callIdExists1(article) || articles.callIdExists2(article) || articles.callIdExists3(article)) {
                String help = article.getCallIdOrigin();
                help += "(" + i + ")";
                article.setCallId(help);
            } else {
                return false;
            }
        }
        return true;
    }
    
    public static Boolean validateInproceedingsCallId(Inproceedings inpro, InproceedingsRepository inpros) {
        inpro.setCallIdOrigin(inpro.getCallId());
        for (int i = 1; i <= 1000; i++) {
            if (inpros.callIdExists1(inpro) || inpros.callIdExists2(inpro) || inpros.callIdExists3(inpro)) {
                String help = inpro.getCallIdOrigin();
                help += "(" + i + ")";
                inpro.setCallId(help);
            } else {
                return false;
            }
        }
        return true;
    }
}
