package me.vaimon.antgallery.domain.repository

import me.vaimon.antgallery.domain.entity.PictureEntity

interface PictureRepository {
    suspend fun getPictures(): List<PictureEntity>
}