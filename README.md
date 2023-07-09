### Spring Web Flux with Kotlin Coroutines

![img.png](img.png)
### Description
A sample http server built using:
- Spring Web Flux
- Kotlin Coroutines
- Postgres and R2DBC to provide reactive connections into db
- Functional request routing
- Test Containers

### Functional Routing Example

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
### Test Containers
Test containers are new features brought from Spring Boot 3 
and allow you to start containers while testing. As soon as you run integration tests,
test containers will be deployed and used. As soon as tests are executed, 
containers are removed. 

### P.S. This example was given in a [speech presented By Josh Long](https://www.youtube.com/watch?v=pXtTp4Uxuhk&ab_channel=KotlinbyJetBrains)

