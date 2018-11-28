package se.torgammelgard.demo1

import org.springframework.data.repository.CrudRepository

interface ArticleRepository : CrudRepository<Article, Long>