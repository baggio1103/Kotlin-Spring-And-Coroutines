package com.javajedi.service

import com.javajedi.model.User
import com.javajedi.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class UserService(
    private val userRepository: UserRepository,
) {

    suspend fun saveUser(user: User): User {
        userRepository.findByEmail(user.email)
            .firstOrNull()
            ?.let { throw ResponseStatusException(HttpStatus.BAD_REQUEST) }
        return userRepository.save(user)
    }

    suspend fun findAllUsers() = userRepository.findAll()

    suspend fun findById(id: Long): User {
        return userRepository.findById(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    suspend fun deleteById(id: Long) {
        userRepository.deleteById(id)
    }

    suspend fun updateById(id: Long, requestedUser: User) {
        val user = userRepository.findById(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
        userRepository.save(
            requestedUser.copy(id = user.id)
        )
    }

    suspend fun findByCompanyId(companyId: Long): Flow<User> = userRepository.findByCompanyId(companyId)

    suspend fun findByNameLike(name: String): Flow<User> = userRepository.findAllByNameContaining(name)


}