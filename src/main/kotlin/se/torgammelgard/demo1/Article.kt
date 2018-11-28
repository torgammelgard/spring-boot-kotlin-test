package se.torgammelgard.demo1

import javax.persistence.*

@Entity
data class Article(@Column val title: String) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0
}
