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
    override suspend fun getPictures(): List<PictureEntity> {
//        delay(2000L)
        return assetDataSource.getDummiePictures().map {
            pictureMapper.from(it)
        }
    }
}