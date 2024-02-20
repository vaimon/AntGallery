package me.vaimon.antgallery.di.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.vaimon.antgallery.data.db.AppDatabase
import me.vaimon.antgallery.data.mapper.Mapper
import me.vaimon.antgallery.data.models.UserData
import me.vaimon.antgallery.data.repository.AuthorizationRepositoryImpl
import me.vaimon.antgallery.domain.entity.UserEntity
import me.vaimon.antgallery.domain.repository.AuthorizationRepository

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideCharacterRepository(
        db: AppDatabase,
        userDomainDataMapper: Mapper<UserEntity, UserData>
    ): AuthorizationRepository {
        return AuthorizationRepositoryImpl(
            db,
            userDomainDataMapper
        )
    }
}