package com.javajedi.service

import com.javajedi.dto.IdNameTypeResponse
import com.javajedi.extension.toIdNameTypeResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import org.springframework.stereotype.Service

@Service
class SearchingService(
    private val userService: UserService,
    private val companyService: CompanyService
) {

    suspend fun search(name: String): Flow<IdNameTypeResponse> {
        val users = userService.findByNameLike(name).map { it.toIdNameTypeResponse() }
        val companies = companyService.findByNameLike(name).map { it.toIdNameTypeResponse() }
        return merge(users, companies)
    }


}