package com.javajedi.model.repository

import com.javajedi.model.User
import kotlinx.coroutines.flow.Flow
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface UserRepository: CoroutineCrudRepository<User, Long> {

    fun findAllByNameContaining(name: String): Flow<User>

    fun findByCompanyId(companyId: Long): Flow<User>

    @Query("""
        SELECT * FROM users
        WHERE email = :email
    """)
    fun findByEmail(email: String): Flow<User>

    suspend fun findByName(name: String): User?


}