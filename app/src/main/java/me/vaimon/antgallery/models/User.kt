package me.vaimon.antgallery.models

import java.time.LocalDate

class User (
    val name: String,
    val birthDay: LocalDate?,
    val phone: String,
    val email: String,
    val password: String
)