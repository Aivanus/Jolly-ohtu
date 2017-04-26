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
            String s = replaceNordic(article.toString());
            sb.append(s);
        }
        for (Book book : bookList) {
            String s = replaceNordic(book.toString());
            sb.append(s);
        }

        for (Inproceedings inproceeding : inproceedingList) {
            String s = replaceNordic(inproceeding.toString());
            sb.append(s);
        }

        String result = sb.toString();

        file.setContentType("text/plain");
        file.setContent(result);
        return this.file;
    }

    private String replaceNordic(String str) {
        String result = str.replaceAll("ä", "\\\\\"{a}")
                .replaceAll("Ä", "\\\\\"{A}")
                .replaceAll("ö", "\\\\\"{o}")
                .replaceAll("Ö", "\\\\\"{O}")
                .replaceAll("å", "\\\\\"{aa}")
                .replaceAll("Å", "\\\\\"{AA}");
        return result;
    }
}
