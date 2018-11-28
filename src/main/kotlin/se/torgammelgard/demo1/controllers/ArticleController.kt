package se.torgammelgard.demo1.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView
import se.torgammelgard.demo1.entities.Article
import se.torgammelgard.demo1.repositories.ArticleRepository

@Controller
@RequestMapping("/article", consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE])
class ArticleController {

    @Autowired
    private lateinit var articleRepository: ArticleRepository

    @PostMapping
    fun addArticleFromForm(@RequestParam body: Map<String, String>): ModelAndView {
        return if (body["title"] != null && body["title"]!!.isNotEmpty()) {
            articleRepository.save(Article(body["title"]))
            ModelAndView("redirect:/blog", HttpStatus.OK)
        } else {
            ModelAndView("redirect:/error", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}