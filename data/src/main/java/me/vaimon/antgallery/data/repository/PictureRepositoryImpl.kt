package me.vaimon.antgallery.data.repository

import kotlinx.coroutines.delay
import me.vaimon.antgallery.data.datasource.AssetDataSource
import me.vaimon.antgallery.data.mapper.Mapper
import me.vaimon.antgallery.data.models.PictureData
import me.vaimon.antgallery.domain.entity.PictureEntity
import me.vaimon.antgallery.domain.repository.PictureRepository

class PictureRepositoryImpl(
    private val assetDataSource: AssetDataSource,
    private val pictureMapper: Mapper<PictureEntity, PictureData>
): PictureRepository {
    override suspend fun getNewPictures(): List<PictureEntity> {
        return assetDataSource.getDummiePictures().map {
            pictureMapper.from(it)
        }
    }

    override suspend fun getPopularPictures(): List<PictureEntity> {
        delay(1000L)
        return emptyList()
    }
}