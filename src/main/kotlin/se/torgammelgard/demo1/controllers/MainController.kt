package se.torgammelgard.demo1.controllers;

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.RequestMapping
import se.torgammelgard.demo1.repositories.ArticleRepository


@Controller
class MainController {

    @Autowired
    private lateinit var articleRepository: ArticleRepository

    @Value("\${blog.title}")
    private lateinit var blogTitle: String

    @RequestMapping("/blog")
    fun root(model: Model): String {
        model["title"] = blogTitle
        model["articles"] = articleRepository.findAll()
        return "blog"
    }

}
