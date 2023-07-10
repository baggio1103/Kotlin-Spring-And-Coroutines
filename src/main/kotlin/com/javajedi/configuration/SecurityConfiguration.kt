package com.javajedi.configuration

import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.web.SecurityFilterChain

@EnableWebFluxSecurity
class SecurityConfiguration {

    fun httpSecurityFilterChain(httpSecurity: HttpSecurity): SecurityFilterChain {
       return httpSecurity.build()
    }

}