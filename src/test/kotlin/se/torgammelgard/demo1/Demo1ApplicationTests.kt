package se.torgammelgard.demo1

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import javax.sql.DataSource

@ExtendWith(SpringExtension::class)
@SpringBootTest
class Demo1ApplicationTests {

    @Autowired
    lateinit var dataSource: DataSource

    @Test
    fun contextLoads() {
    }

}
