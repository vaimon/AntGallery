package me.vaimon.antgallery.domain.usecase.validation

class ValidateEmailUseCase {
    private val emailRegex = """^[a-z0-9!#${'$'}%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#${'$'}%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?${'$'}""".toRegex()
    operator fun invoke(input: String? = null): Boolean{
        return input?.matches(emailRegex) ?: false
    }
}