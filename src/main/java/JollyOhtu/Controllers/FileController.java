package JollyOhtu.Controllers;

import JollyOhtu.Objects.FileObject;
import JollyOhtu.Repository.ArticleRepository;
import JollyOhtu.Repository.BookRepository;
import JollyOhtu.Repository.InproceedingsRepository;
import JollyOhtu.Service.FileGeneratorService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Arttu
 */
@Controller
public class FileController {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private InproceedingsRepository inproceedingsRepository;

    @RequestMapping(value = "/download", method = GET)
    public String index() {
        return "download";
    }

    @RequestMapping(value = "download", method = RequestMethod.POST)
    public ResponseEntity<String> loadFile(@RequestParam("name") String name) throws IOException {

        FileGeneratorService fgs = new FileGeneratorService();
        FileObject fo = fgs.generateFile(bookRepository.findAll(), articleRepository.findAll(), inproceedingsRepository.findAll());
        fo.setName(name);
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.add("Content-Disposition", "attachment; filename=" + fo.getName());

        return new ResponseEntity<>(fo.getContent(), headers, HttpStatus.CREATED);
    }

}
