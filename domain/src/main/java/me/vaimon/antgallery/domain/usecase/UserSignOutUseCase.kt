package me.vaimon.antgallery.domain.usecase

import me.vaimon.antgallery.domain.entity.UserEntity
import me.vaimon.antgallery.domain.repository.AuthorizationRepository
import javax.inject.Inject

class UserSignOutUseCase @Inject constructor(
    private val authorizationRepository: AuthorizationRepository
) {
    operator fun invoke(){
        authorizationRepository.signOut()
    }
}