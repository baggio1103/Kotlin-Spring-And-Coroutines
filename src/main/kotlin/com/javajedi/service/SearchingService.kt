package com.javajedi.service

import com.javajedi.dto.IdNameTypeResponse
import com.javajedi.extension.toIdNameTypeResponse
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import org.springframework.stereotype.Service

@Service
class SearchingService(
    private val userService: UserService,
    private val companyService: CompanyService
) {

    suspend fun search(name: String?): Flow<IdNameTypeResponse> {
        val users = name?.let {
            userService.findByNameLike(it)
        } ?: userService.findAllUsers()
        val companies = name?.let {
            companyService.findByNameLike(it)
        } ?: companyService.findAll()
        return merge(
            users.map { it.toIdNameTypeResponse() },
            companies.map { it.toIdNameTypeResponse() }
        )
    }

    suspend fun delayedSyncSearch(name: String?): Flow<IdNameTypeResponse> {
        val users = name?.let {
            delay(2000)
            userService.findByNameLike(it)
        } ?: run {
            delay(2000)
            userService.findAllUsers()
        }
        val companies = name?.let {
            delay(2000)
            companyService.findByNameLike(it)
        } ?: run {
            delay(2000)
            companyService.findAll()
        }
        return merge(
            users.map { it.toIdNameTypeResponse() },
            companies.map { it.toIdNameTypeResponse() }
        )
    }

    suspend fun delayedASyncSearch(name: String?): Flow<IdNameTypeResponse> {
        return coroutineScope {
            val users = async {
                name?.let {
                    delay(2000)
                    userService.findByNameLike(it)
                } ?: run {
                    delay(2000)
                    userService.findAllUsers()
                }
            }
           val companies = async {
                name?.let {
                    delay(2000)
                    companyService.findByNameLike(it)
                } ?:run {
                    delay(2000)
                    companyService.findAll()
                }
            }
            merge(
                users.await().map { it.toIdNameTypeResponse() },
                companies.await().map { it.toIdNameTypeResponse() },
            )
        }
    }

}
