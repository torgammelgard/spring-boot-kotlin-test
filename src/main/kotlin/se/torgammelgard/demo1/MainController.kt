package se.torgammelgard.demo1;

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody


@Controller
class MainController {

    private val articles = listOf(
            Article("The extended phenotype", 1),
            Article("A tale of two cities", 2),
            Article("Animal farm", 3))

    @Value("\${blog.title}")
    private lateinit var blogTitle: String

    @GetMapping("/")
    fun root(model: Model): String {
        model["title"] = blogTitle
        model["articles"] = articles
        return "blog"
    }

}
