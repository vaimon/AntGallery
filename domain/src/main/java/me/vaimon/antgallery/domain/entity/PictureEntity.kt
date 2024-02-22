package me.vaimon.antgallery.domain.entity

import java.time.LocalDateTime

data class PictureEntity (
    val imgUri: String,
    val title: String,
    val description: String,
    val ownerUserId: Int,
    val timestamp: LocalDateTime
)