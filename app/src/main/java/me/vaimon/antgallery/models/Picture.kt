package me.vaimon.antgallery.models

import java.time.LocalDateTime

class Picture(
    val imgUri: String,
    val title: String,
    val description: String,
    val ownerUserId: Int,
    val timestamp: LocalDateTime
)