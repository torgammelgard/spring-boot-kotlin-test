package se.torgammelgard.demo1.services

interface BasicService<T> {
    fun save(entity: T): T?
    fun findAll(): Iterable<T>
}