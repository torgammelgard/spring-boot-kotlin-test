package se.torgammelgard.demo1

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@RestController
class ArticleRestController {

    @Autowired
    lateinit var articleRepository: ArticleRepository

    @GetMapping("/article/{id}")
    fun getArticleForId(@PathVariable id: Long, model: Model): ResponseEntity<Article> {
        val article = articleRepository.findById(id)
        print(article)
        return ResponseEntity.of(articleRepository.findById(id))
    }

    @PostMapping("/article",
            consumes = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE],
            produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE])
    fun addArticle(@RequestBody article: Article): ResponseEntity<Article> {
        val savedArticle = articleRepository.save(article)
        return ResponseEntity(savedArticle, HttpStatus.OK)
    }
}