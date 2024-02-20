package me.vaimon.antgallery.domain.usecase.validation

class ValidatePhoneUseCase {
    private val phoneRegex = """(\+7|8)[- _]*\(?[- _]*(\d{3}[- _]*\)?([- _]*\d){7}|\d\d[- _]*\d\d[- _]*\)?([- _]*\d){6})""".toRegex()
    operator fun invoke(input: String? = null): Boolean{
        return input?.matches(phoneRegex) ?: false
    }
}