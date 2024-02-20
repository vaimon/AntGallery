package me.vaimon.antgallery.domain.usecase.validation

class ValidatePasswordUseCase {
    operator fun invoke(input: String? = null): Boolean{
        return input?.matches("""\S{6,}""".toRegex()) ?: false
    }
}