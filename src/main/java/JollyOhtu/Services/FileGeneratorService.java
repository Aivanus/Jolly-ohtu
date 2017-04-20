package JollyOhtu.Services;

import JollyOhtu.Objects.Article;
import JollyOhtu.Objects.Book;
import JollyOhtu.Objects.FileObject;
import JollyOhtu.Objects.Inproceedings;
import JollyOhtu.Repository.ArticleRepository;
import JollyOhtu.Repository.BookRepository;
import JollyOhtu.Repository.InproceedingsRepository;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Arttu
 */
@Service
public class FileGeneratorService {

    private FileObject file;

    public FileObject generateFile(Iterable<Book> books, Iterable<Article> articles, Iterable<Inproceedings> inpros) throws IOException {
        this.file = new FileObject();
        Iterable<Article> articleList = articles;
        Iterable<Book> bookList = books;
        Iterable<Inproceedings> inproceedingList = inpros;
        StringBuilder sb = new StringBuilder();
        
        for (Article article : articleList) {
            sb.append(article.toString());
        }
        for (Book book : bookList) {
            sb.append(book.toString());
        }

        for (Inproceedings inproceeding : inproceedingList) {
            sb.append(inproceeding.toString());
        }

        String result = sb.toString();

        file.setName("Testitiedosto.bib");
        file.setContentType("text/plain");
        file.setContent(result);
        return this.file;
    }
}
