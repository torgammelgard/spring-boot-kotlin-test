package se.torgammelgard.demo1.entities

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.*

class ArticleTest {

    private val testTitle = "Test title"
    private val testContent = "Test content"

    @Test
    fun testArticleEquals() {
        val articleOne = Article(testTitle, testContent)
        val articleTwo = Article(testTitle, testContent)
        assertThat(articleOne == articleTwo)
    }
}