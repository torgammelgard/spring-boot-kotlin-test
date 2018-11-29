package se.torgammelgard.demo1.services.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import se.torgammelgard.demo1.entities.Article
import se.torgammelgard.demo1.repositories.ArticleRepository
import se.torgammelgard.demo1.services.ArticleService

@Service
class ArticleServiceImpl : ArticleService {

    @Autowired
    private lateinit var articleRepository: ArticleRepository

    override fun save(entity: Article): Article? {
        if (entity.title.isNullOrEmpty()) {
            return null
        }
        return articleRepository.save(entity)
    }

    override fun findAll(): Iterable<Article> {
        return articleRepository.findAll()
    }
}