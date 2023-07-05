package com.javajedi.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("users")
data class User(

    @Id
    val id: Long? = null,

    val name: String,

    val age: Int,

    val email: String,

    val companyId: Long

)