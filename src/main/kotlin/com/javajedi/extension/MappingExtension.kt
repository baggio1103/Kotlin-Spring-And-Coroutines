package com.javajedi.extension

import com.javajedi.dto.CompanyRequest
import com.javajedi.dto.UserRequest
import com.javajedi.dto.UserResponse
import com.javajedi.model.Company
import com.javajedi.model.User
import java.lang.IllegalArgumentException

fun CompanyRequest.toModel(): Company = Company(
    name = name,
    address = address
)

fun UserRequest.toModel(): User = User(
    name = name, age = age,
    email = email,
    companyId = companyId
)


fun User.toResponse(): UserResponse = UserResponse(
    id ?: throw IllegalArgumentException("Id cannot be null"),
    age,
    email,
    name
)
