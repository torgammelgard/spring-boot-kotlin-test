package se.torgammelgard.demo1

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@RestController
class ArticleRestController {

    @GetMapping("/article/{id}")
    fun getArticleForId(@PathVariable id: Long, model: Model): ResponseEntity<Article> {
        throw NotImplementedError()
    }

    @PostMapping("/article",
            consumes = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE],
            produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE])
    fun addArticle(@RequestBody article: Article): ResponseEntity<Article> {
        return ResponseEntity(article, HttpStatus.OK)
    }
}