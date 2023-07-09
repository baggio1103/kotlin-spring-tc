package com.javajedi

import kotlinx.coroutines.flow.count
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class SpringApplicationTests(
   @Autowired val customerRepository: CustomerRepository
) {

    @Test
    fun contextLoads() {
        runBlocking {
            customerRepository.save(Customer(name = "Ann"))
            val customers = customerRepository.findAll()
            assertThat(customers.count()).isEqualTo(6)
        }
    }

}
