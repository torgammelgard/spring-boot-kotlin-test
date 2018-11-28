package se.torgammelgard.demo1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.boot.test.web.client.postForEntity
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import javax.sql.DataSource

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class Demo1ApplicationTests(@Autowired val testRestTemplate: TestRestTemplate) {

    @Autowired
    lateinit var dataSource: DataSource

    @Value("\${blog.title}")
    lateinit var blogTitle: String

    @Test
    fun `Assert that context loads`() {
    }

    @Test
    fun `Assert home page title`() {
        val entity = testRestTemplate.getForEntity<String>("/")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(entity.body).contains("<title>$blogTitle</title>")
    }

    @Test
    fun `Assert that article can be posted`() {
        val headers = HttpHeaders()
        val article = Article("test article", 28)
        val request = HttpEntity(article, headers)
        val entity = testRestTemplate.postForEntity<String>("/article", request)
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
    }
}
