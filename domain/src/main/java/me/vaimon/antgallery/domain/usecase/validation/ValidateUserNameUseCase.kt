package me.vaimon.antgallery.domain.usecase.validation

import java.time.LocalDate

class ValidateUserNameUseCase {
    operator fun invoke(input: String? = null): Boolean{
        return input?.matches("""\w[\w \-]*""".toRegex()) ?: false
    }
}