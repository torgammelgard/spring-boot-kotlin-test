package se.torgammelgard.demo1;

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

data class Article(val title: String, val id: Long)

@Controller
class MainController {

    @GetMapping("/")
    fun root(model: Model): String {
        model["title"] = "Blog"
        model["articles"] = listOf(
                Article("The extended phenotype", 1),
                Article("A tale of two cities", 2),
                Article("Animal farm", 3))
        return "blog"
    }
}
