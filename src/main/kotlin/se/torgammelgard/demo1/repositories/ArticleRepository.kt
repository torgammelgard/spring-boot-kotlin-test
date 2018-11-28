package se.torgammelgard.demo1.repositories

import org.springframework.data.repository.CrudRepository
import se.torgammelgard.demo1.entities.Article

interface ArticleRepository : CrudRepository<Article, Long>