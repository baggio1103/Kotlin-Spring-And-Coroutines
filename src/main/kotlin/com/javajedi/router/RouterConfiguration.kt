package com.javajedi.router

import com.javajedi.GreetingService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
class RouterConfiguration {

    @Bean
    fun apiRouter(greetingService: GreetingService) = router {
        GET("/api/v1/greeting") {
            _ -> ServerResponse.ok()
        }

    }


}