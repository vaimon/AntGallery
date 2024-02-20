package me.vaimon.antgallery.domain.usecase.validation

import java.time.LocalDate

class ValidateBirthDayUseCase {
    operator fun invoke(input: LocalDate? = null): Boolean{
        return input?.isBefore(LocalDate.now()) ?: true
    }
}