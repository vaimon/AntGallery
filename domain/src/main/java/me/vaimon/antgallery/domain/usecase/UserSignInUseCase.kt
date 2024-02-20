package me.vaimon.antgallery.domain.usecase

import me.vaimon.antgallery.domain.entity.LoginCredentialsEntity
import me.vaimon.antgallery.domain.entity.UserEntity
import me.vaimon.antgallery.domain.repository.AuthorizationRepository
import javax.inject.Inject

class UserSignInUseCase @Inject constructor(
    private val authorizationRepository: AuthorizationRepository
) {
    suspend operator fun invoke(userCredentials: LoginCredentialsEntity){
        authorizationRepository.signIn(userCredentials)
    }
}