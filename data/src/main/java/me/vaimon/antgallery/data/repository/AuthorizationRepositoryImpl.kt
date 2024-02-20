package me.vaimon.antgallery.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import me.vaimon.antgallery.data.db.AppDatabase
import me.vaimon.antgallery.data.mapper.Mapper
import me.vaimon.antgallery.data.models.UserData
import me.vaimon.antgallery.domain.entity.UserEntity
import me.vaimon.antgallery.domain.repository.AuthorizationRepository
import javax.inject.Inject

class AuthorizationRepositoryImpl @Inject constructor(
    private val db: AppDatabase,
    private val userDomainDataMapper: Mapper<UserEntity, UserData>
): AuthorizationRepository {
    override suspend fun signUp(user: UserEntity) = withContext(Dispatchers.IO) {
        if(db.userDao().getUserByEmail(user.email) != null){
            throw IllegalArgumentException("A user with this email already exists")
        }
        db.userDao().insert(userDomainDataMapper.to(user))
    }
}