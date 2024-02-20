package me.vaimon.antgallery.domain.repository

import me.vaimon.antgallery.domain.entity.LoginCredentialsEntity
import me.vaimon.antgallery.domain.entity.UserEntity

interface AuthorizationRepository {
    suspend fun signUp(user: UserEntity)
    suspend fun signIn(credentials: LoginCredentialsEntity): Int
}