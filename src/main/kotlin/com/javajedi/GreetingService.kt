package com.javajedi

import kotlinx.coroutines.delay
import org.springframework.stereotype.Service

@Service
class GreetingService {

    suspend fun hello(): String {
        delay(100)
        return "Hello world"
    }

}