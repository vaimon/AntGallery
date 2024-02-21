package me.vaimon.antgallery.domain.usecase

import me.vaimon.antgallery.domain.repository.AuthorizationRepository
import javax.inject.Inject

class GetLoggedUserIdUseCase @Inject constructor(
    private val authorizationRepository: AuthorizationRepository
){
    operator fun invoke(): Int? = authorizationRepository.getLoggedUserId()
}