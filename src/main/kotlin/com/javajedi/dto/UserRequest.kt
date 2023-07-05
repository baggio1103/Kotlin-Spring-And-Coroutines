package com.javajedi.dto

data class UserRequest(
    val age: Int,
    val email: String,
    val name: String,
    val companyId: Long
)