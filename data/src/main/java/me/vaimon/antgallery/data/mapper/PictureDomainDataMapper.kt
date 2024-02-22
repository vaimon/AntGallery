package me.vaimon.antgallery.data.mapper

import me.vaimon.antgallery.data.models.PictureData
import me.vaimon.antgallery.domain.entity.PictureEntity
import javax.inject.Inject

class PictureDomainDataMapper @Inject constructor(): Mapper<PictureEntity, PictureData> {
    override fun from(e: PictureData): PictureEntity = PictureEntity(
        imgUri = e.imgUri,
        title = e.title,
        description = e.description,
        ownerUserId = e.ownerUserId,
        timestamp = e.timestamp
    )

    override fun to(t: PictureEntity): PictureData = PictureData(
        imgUri = t.imgUri,
        title = t.title,
        description = t.description,
        ownerUserId = t.ownerUserId,
        timestamp = t.timestamp
    )
}