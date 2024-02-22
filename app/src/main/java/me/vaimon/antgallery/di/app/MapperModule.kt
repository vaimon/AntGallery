package me.vaimon.antgallery.di.app

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.vaimon.antgallery.data.mapper.Mapper
import me.vaimon.antgallery.domain.entity.LoginCredentialsEntity
import me.vaimon.antgallery.domain.entity.PictureEntity
import me.vaimon.antgallery.domain.entity.UserEntity
import me.vaimon.antgallery.mapper.PictureAppDomainMapper
import me.vaimon.antgallery.mapper.UserAppDomainMapper
import me.vaimon.antgallery.mapper.UserCredentialsMapper
import me.vaimon.antgallery.models.Picture
import me.vaimon.antgallery.models.User

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

    @Binds
    abstract fun provideUserAppDomainMapper(
        userAppDomainMapper: UserAppDomainMapper
    ): Mapper<User, UserEntity>

    @Binds
    abstract fun provideUserCredentialsMapper(
        userCredentialsMapper: UserCredentialsMapper
    ): Mapper<User, LoginCredentialsEntity>

    @Binds
    abstract fun providePictureMapper(
        pictureMapper: PictureAppDomainMapper
    ): Mapper<Picture, PictureEntity>
}