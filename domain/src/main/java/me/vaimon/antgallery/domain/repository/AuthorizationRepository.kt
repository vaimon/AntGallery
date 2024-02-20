package me.vaimon.antgallery.domain.repository

import me.vaimon.antgallery.domain.entity.UserEntity

interface AuthorizationRepository {
    suspend fun signUp(user: UserEntity)
}