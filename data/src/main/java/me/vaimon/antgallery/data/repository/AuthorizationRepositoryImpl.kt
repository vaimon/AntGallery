package me.vaimon.antgallery.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import me.vaimon.antgallery.data.datasource.SharedPreferencesDataSource
import me.vaimon.antgallery.data.db.AppDatabase
import me.vaimon.antgallery.data.mapper.Mapper
import me.vaimon.antgallery.data.models.UserData
import me.vaimon.antgallery.data.utils.AuthorizationException
import me.vaimon.antgallery.domain.entity.LoginCredentialsEntity
import me.vaimon.antgallery.domain.entity.UserEntity
import me.vaimon.antgallery.domain.repository.AuthorizationRepository
import javax.inject.Inject

class AuthorizationRepositoryImpl @Inject constructor(
    private val db: AppDatabase,
    private val userDomainDataMapper: Mapper<UserEntity, UserData>,
    private val sharedPrefsDataSource: SharedPreferencesDataSource
): AuthorizationRepository {
    override suspend fun signUp(user: UserEntity) = withContext(Dispatchers.IO) {
        if(db.userDao().getUserByEmail(user.email) != null){
            throw AuthorizationException.UserAlreadyExists()
        }
        db.userDao().insert(userDomainDataMapper.to(user))
    }

    override suspend fun signIn(credentials: LoginCredentialsEntity): Int {
        val user = db.userDao().getUserByEmail(credentials.email)
            ?: throw AuthorizationException.UserNotFound()
        if(user.password != credentials.password){
            throw AuthorizationException.InvalidPassword()
        }
        sharedPrefsDataSource.setLoggedUserId(user.id)
        return user.id
    }

    override fun signOut() {
        sharedPrefsDataSource.clearLoggedUserId()
    }

    override fun getLoggedUserId(): Int? = sharedPrefsDataSource.getLoggedUserId()
}