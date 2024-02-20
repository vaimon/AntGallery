package me.vaimon.antgallery.di.domain

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.vaimon.antgallery.domain.usecase.validation.ValidateBirthDayUseCase
import me.vaimon.antgallery.domain.usecase.validation.ValidateEmailUseCase
import me.vaimon.antgallery.domain.usecase.validation.ValidatePasswordUseCase
import me.vaimon.antgallery.domain.usecase.validation.ValidatePhoneUseCase
import me.vaimon.antgallery.domain.usecase.validation.ValidateUserNameUseCase

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun provideValidateBirthDayUseCase(): ValidateBirthDayUseCase{
        return ValidateBirthDayUseCase()
    }

    @Provides
    fun provideValidateUserNameUseCase(): ValidateUserNameUseCase{
        return ValidateUserNameUseCase()
    }

    @Provides
    fun provideValidateEmailUseCase(): ValidateEmailUseCase{
        return ValidateEmailUseCase()
    }

    @Provides
    fun provideValidatePhoneUseCase(): ValidatePhoneUseCase{
        return ValidatePhoneUseCase()
    }

    @Provides
    fun provideValidatePasswordUseCase(): ValidatePasswordUseCase{
        return ValidatePasswordUseCase()
    }
}