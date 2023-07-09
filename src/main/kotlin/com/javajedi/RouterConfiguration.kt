package com.javajedi

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.*

@Configuration
class RouterConfiguration {

    @Bean
    fun http(customerRepository: CustomerRepository): RouterFunction<ServerResponse> = coRouter {
        GET("/customers") {
           ServerResponse.ok().bodyAndAwait(customerRepository.findAll())
        }
        GET("/customers/{id}") {
            val id = it.pathVariable("id").toInt()
            val customer = customerRepository.findById(id)
            if (customer != null)
                ServerResponse.ok().bodyValueAndAwait(customer)
            else
                ServerResponse.notFound().buildAndAwait()
        }
    }

}