package com.javajedi.model.service

import com.javajedi.model.User
import com.javajedi.model.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class UserService(
    private val userRepository: UserRepository
) {

    suspend fun saveUser(user: User) {
        userRepository.findByEmail(user.email)
            .firstOrNull()
            ?.let { throw ResponseStatusException(HttpStatus.BAD_REQUEST) }
        userRepository.save(user)
    }

    suspend fun findAllUsers() = userRepository.findAll()

    suspend fun findById(id: Long): User? = userRepository.findById(id)

    suspend fun deleteById(id: Long) {
        userRepository.deleteById(id)
    }

    suspend fun updateById(id: Long, requestedUser: User) {
        val user = userRepository.findById(id) ?: throw throw ResponseStatusException(HttpStatus.NOT_FOUND)
        userRepository.save(
            requestedUser.copy(id = user.id)
        )
    }

    suspend fun findByCompanyId(companyId: Long): Flow<User> = userRepository.findByCompanyId(companyId)

    suspend fun findByNameLike(name: String): Flow<User> = userRepository.findAllByNameContaining(name)


}