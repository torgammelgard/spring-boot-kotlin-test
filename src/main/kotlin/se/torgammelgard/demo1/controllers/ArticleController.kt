package se.torgammelgard.demo1.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView
import se.torgammelgard.demo1.entities.Article
import se.torgammelgard.demo1.services.ArticleService

@Controller
@RequestMapping("/article", consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE])
class ArticleController {

    @Autowired
    private lateinit var articleService: ArticleService

    @PostMapping
    fun addArticleFromForm(@RequestParam body: Map<String, String>): ModelAndView {
        val article = Article(body["title"], body["content"])
        articleService.save(article)
        return ModelAndView("redirect:/blog")
    }
}