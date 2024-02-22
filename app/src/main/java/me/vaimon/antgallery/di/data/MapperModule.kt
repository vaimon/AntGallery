package me.vaimon.antgallery.di.data

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.vaimon.antgallery.data.mapper.Mapper
import me.vaimon.antgallery.data.mapper.PictureDomainDataMapper
import me.vaimon.antgallery.data.mapper.UserDomainDataMapper
import me.vaimon.antgallery.data.models.PictureData
import me.vaimon.antgallery.data.models.UserData
import me.vaimon.antgallery.domain.entity.PictureEntity
import me.vaimon.antgallery.domain.entity.UserEntity

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

    @Binds
    abstract fun provideUserDomainDataMapper(
        userDomainDataMapper: UserDomainDataMapper
    ): Mapper<UserEntity, UserData>

    @Binds
    abstract fun providePictureDomainDataMapper(
        pictureDomainDataMapper: PictureDomainDataMapper
    ): Mapper<PictureEntity, PictureData>
}