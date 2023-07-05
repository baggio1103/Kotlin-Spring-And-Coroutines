package com.javajedi.dto

import com.javajedi.model.User

data class CompanyResponse(
    val id: Long,
    val name: String,
    val address: String,
    val users: List<User>
)