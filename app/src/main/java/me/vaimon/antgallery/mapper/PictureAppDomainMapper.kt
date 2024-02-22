package me.vaimon.antgallery.mapper

import me.vaimon.antgallery.data.mapper.Mapper
import me.vaimon.antgallery.domain.entity.PictureEntity
import me.vaimon.antgallery.models.Picture
import javax.inject.Inject

class PictureAppDomainMapper @Inject constructor(): Mapper<Picture, PictureEntity> {
    override fun from(e: PictureEntity): Picture {
        return Picture(
            imgUri = e.imgUri,
            title = e.title,
            description = e.description,
            ownerUserId = e.ownerUserId,
            timestamp = e.timestamp
        )
    }

    override fun to(t: Picture): PictureEntity {
        return PictureEntity(
            imgUri = t.imgUri,
            title = t.title,
            description = t.description,
            ownerUserId = t.ownerUserId,
            timestamp = t.timestamp
        )
    }

}