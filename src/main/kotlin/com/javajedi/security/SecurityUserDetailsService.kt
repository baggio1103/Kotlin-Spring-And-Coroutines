package com.javajedi.security

import org.springframework.security.core.userdetails.ReactiveUserDetailsService
import org.springframework.security.core.userdetails.UserDetails
import reactor.core.publisher.Mono


class SecurityUserDetailsService: ReactiveUserDetailsService {

    override fun findByUsername(username: String?): Mono<UserDetails> {
        TODO("Not yet implemented")
    }

}