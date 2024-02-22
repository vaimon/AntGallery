package me.vaimon.antgallery.data.models

import android.net.Uri
import java.time.LocalDateTime

data class PictureData(
    val imgUri: String,
    val title: String,
    val description: String,
    val ownerUserId: Int,
    val timestamp: LocalDateTime
)