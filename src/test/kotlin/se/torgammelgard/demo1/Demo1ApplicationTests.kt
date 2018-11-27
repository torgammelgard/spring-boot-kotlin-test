package se.torgammelgard.demo1

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.test.context.junit.jupiter.SpringExtension
import javax.sql.DataSource

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Demo1ApplicationTests(@Autowired val testRestTemplate: TestRestTemplate) {

    @Autowired
    lateinit var dataSource: DataSource

    @Test
    fun `Assert that context loads`() {
    }

    @Test
    fun `Assert home page title`() {
        val entity = testRestTemplate.getForEntity<String>("/")
    }
}
