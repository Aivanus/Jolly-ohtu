/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JollyOhtu.Services;

import JollyOhtu.Objects.Article;
import JollyOhtu.Repository.ArticleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


@Service
@Primary
public class ArticleService {
    
    @Autowired
    private ArticleRepository artRepo;
    
    
    public Article findById(Long id) {
        return this.artRepo.findOne(id);
    }
    
    public Article edit(Article article) {
        return this.artRepo.save(article);
    }
    
    public void deleteById(Long id) {
        this.artRepo.delete(id);
    }
    
}
