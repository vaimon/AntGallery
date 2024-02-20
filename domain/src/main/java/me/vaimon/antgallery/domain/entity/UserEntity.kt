package me.vaimon.antgallery.domain.entity

import java.time.LocalDate

data class UserEntity(
    val name: String,
    val birthDay: LocalDate?,
    val phone: String,
    val email: String,
    val password: String?
)