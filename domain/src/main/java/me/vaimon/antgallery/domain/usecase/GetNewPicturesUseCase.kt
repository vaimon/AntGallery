package me.vaimon.antgallery.domain.usecase

import me.vaimon.antgallery.domain.entity.PictureEntity
import me.vaimon.antgallery.domain.repository.AuthorizationRepository
import me.vaimon.antgallery.domain.repository.PictureRepository
import javax.inject.Inject

class GetNewPicturesUseCase  @Inject constructor(
    private val pictureRepository: PictureRepository
){
    suspend operator fun invoke(): List<PictureEntity>{
        return pictureRepository.getPictures()
    }
}