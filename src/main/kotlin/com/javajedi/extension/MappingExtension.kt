package com.javajedi.extension

import com.javajedi.dto.*
import com.javajedi.dto.ResultType.COMPANY
import com.javajedi.dto.ResultType.USER
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

fun Company.toResponse(users: List<User> = emptyList()): CompanyResponse =
    CompanyResponse(
        id ?: throw IllegalArgumentException("Id cannot be null"),
        name,
        address,
        users = users.map( User::toResponse )
    )



fun User.toResponse(): UserResponse = UserResponse(
    id ?: throw IllegalArgumentException("Id cannot be null"),
    age,
    email,
    name
)

fun User.toIdNameTypeResponse(): IdNameTypeResponse = IdNameTypeResponse(
    id ?: throw IllegalArgumentException("Id cannot be null"),
    name,
    USER
)

fun Company.toIdNameTypeResponse(): IdNameTypeResponse = IdNameTypeResponse(
    id ?: throw IllegalArgumentException("Id cannot be null"),
    name,
    COMPANY
)