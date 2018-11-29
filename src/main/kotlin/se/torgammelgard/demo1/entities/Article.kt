package se.torgammelgard.demo1.entities

import javax.persistence.*

@Entity
data class Article(@Column val title: String?, @Column val content: String?) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0
}
