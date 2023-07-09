package com.javajedi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

@SpringBootApplication
class SpringApplication

fun main(args: Array<String>) {
    runApplication<SpringApplication>(*args)
}

interface CustomerRepository : CoroutineCrudRepository<Customer, Int>

@Table("customers")
data class Customer(
    @Id
    val id: Int? = null,
    val name: String
)