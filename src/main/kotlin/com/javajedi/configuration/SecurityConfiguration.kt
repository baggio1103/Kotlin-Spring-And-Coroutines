package com.javajedi.configuration

import org.springframework.context.annotation.Bean
import org.springframework.security.authentication.ReactiveAuthenticationManager
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.core.userdetails.ReactiveUserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@EnableWebFluxSecurity
class SecurityConfiguration {

    @Bean
    fun httpSecurityFilterChain(httpSecurity: HttpSecurity): SecurityFilterChain {
        return httpSecurity.build()
    }

    @Bean
    fun reactiveAuthenticationManager(
        bCryptPasswordEncoder: BCryptPasswordEncoder,
        userDetailsService: ReactiveUserDetailsService
    ): ReactiveAuthenticationManager {
        return UserDetailsRepositoryReactiveAuthenticationManager(userDetailsService).apply {
            setPasswordEncoder(bCryptPasswordEncoder)
        }
    }

    @Bean
    fun bcryptPasswordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

}