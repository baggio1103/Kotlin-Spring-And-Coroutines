package com.javajedi

import kotlinx.coroutines.delay
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController {

    companion object {
        private val log: Logger = LoggerFactory.getLogger(GreetingController::class.java)
    }

    @GetMapping
    fun hello(): String {
        log.info("Hello world")
        return "Hello world"
    }

    @GetMapping("/bye")
    suspend fun bye(): String {
        log.info(Thread.currentThread().name)
        log.info("Bye delay")
        delay(10000)
        log.info("Bye resume")
        return "Bye bye"
    }

}