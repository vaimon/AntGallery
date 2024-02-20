package me.vaimon.antgallery.domain.usecase

import me.vaimon.antgallery.domain.entity.UserEntity
import me.vaimon.antgallery.domain.repository.AuthorizationRepository
import java.lang.IllegalArgumentException
import javax.inject.Inject

class UserSignUpUseCase @Inject constructor(
    private val authorizationRepository: AuthorizationRepository
) {
    suspend operator fun invoke(user: UserEntity){
        authorizationRepository.signUp(user)
    }
}