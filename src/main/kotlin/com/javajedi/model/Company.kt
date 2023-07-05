package com.javajedi.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table(name = "companies")
data class Company(

    @Id
    val id: Long? = null,

    @Column("name")
    val name: String,

    @Column("address")
    val address: String,

)
