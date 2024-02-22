package me.vaimon.antgallery.domain.usecase

import me.vaimon.antgallery.domain.entity.PictureEntity
import me.vaimon.antgallery.domain.repository.PictureRepository
import javax.inject.Inject

class GetPopularPicturesUseCase @Inject constructor(
    private val pictureRepository: PictureRepository
){
    suspend operator fun invoke(): List<PictureEntity>{
        return pictureRepository.getPopularPictures()
    }
}