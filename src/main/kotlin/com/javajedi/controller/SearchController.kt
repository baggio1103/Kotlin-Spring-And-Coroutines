package com.javajedi.controller

import com.javajedi.dto.IdNameTypeResponse
import com.javajedi.service.SearchingService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import kotlinx.coroutines.flow.Flow

@RestController
@RequestMapping("/api/v1/search")
class SearchController(
    private val searchingService: SearchingService
) {

    @GetMapping
    suspend fun searchByName(@RequestParam("name") name: String): Flow<IdNameTypeResponse> {
        return searchingService.search(name)
    }

}