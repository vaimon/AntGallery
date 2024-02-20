package me.vaimon.antgallery.ui.authorization

import me.vaimon.antgallery.domain.usecase.validation.ValidateBirthDayUseCase
import me.vaimon.antgallery.domain.usecase.validation.ValidateEmailUseCase
import me.vaimon.antgallery.domain.usecase.validation.ValidatePasswordUseCase
import me.vaimon.antgallery.domain.usecase.validation.ValidatePhoneUseCase
import me.vaimon.antgallery.domain.usecase.validation.ValidateUserNameUseCase
import me.vaimon.antgallery.utils.AppConstants
import me.vaimon.antgallery.utils.ComparingValidatableField
import me.vaimon.antgallery.utils.ValidatableField
import moxy.MvpPresenter
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.util.Date
import javax.inject.Inject

class AuthorizationPresenter @Inject constructor(
    private val validateUserNameUseCase: ValidateUserNameUseCase,
    private val validateBirthDayUseCase: ValidateBirthDayUseCase,
    private val validateEmailUseCase: ValidateEmailUseCase,
    private val validatePhoneUseCase: ValidatePhoneUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase
): MvpPresenter<AuthorizationView>() {

    private var isSignInMode = false
    private val pickerState: PickerState = PickerState(
        userName = object : ValidatableField<String>(""){
            override fun validate(input: String?): Boolean = validateUserNameUseCase(input)
        },
        birthDate = object : ValidatableField<LocalDate>(){
            override fun validate(input: LocalDate?): Boolean = validateBirthDayUseCase(input)
        },
        phoneNumber = object : ValidatableField<String>(""){
            override fun validate(input: String?): Boolean = validatePhoneUseCase(input)
        },
        email = object : ValidatableField<String>(""){
            override fun validate(input: String?): Boolean = validateEmailUseCase(input)
        },
        password = object : ValidatableField<String>(""){
            override fun validate(input: String?): Boolean = validatePasswordUseCase(input)
        },
        confirmPassword = object : ComparingValidatableField<String>(""){}
    )

    fun setAuthType(newType: AppConstants.AuthType){
        isSignInMode = newType == AppConstants.AuthType.SignIn
        viewState.updateUiType(isSignInMode)
    }

    fun onToggleAuthType(){
        isSignInMode = !isSignInMode
        viewState.updateUiType(isSignInMode)
    }

    fun onNavigateUp() {
        viewState.onNavigateUp()
    }

    fun onBirthdayClicked() {
        viewState.openDatePicker()
    }

    fun onBirthDayPicked(timestamp: Long?) {
        timestamp?.let { millis ->
            pickerState.birthDate.validateAndSet(
                Instant.ofEpochMilli(millis).atZone(ZoneId.systemDefault()).toLocalDate()
            ).also {
                viewState.toggleBirthDayError(!it)
            }
        }
        viewState.updateDate(pickerState.birthDate.value)
    }

    fun onUsernameChanged(input: String?) {
        pickerState.userName.validateAndSet(input).also {
            viewState.toggleUserNameError(!it)
        }
    }

    fun onEmailChanged(input: String?) {
        pickerState.email.validateAndSet(input).also {
            viewState.toggleEmailError(!it)
        }
    }

    fun onPhoneChanged(input: String?) {
        pickerState.phoneNumber.validateAndSet(input).also {
            viewState.togglePhoneError(!it)
        }
    }

    fun onPasswordChanged(input: String?) {
        pickerState.password.validateAndSet(input).also{
            viewState.togglePasswordError(!it)
        }
    }

    fun onPasswordConfirmationChanged(input: String?) {
        pickerState.confirmPassword.compareAndSet(input, pickerState.password.value).also {
            viewState.togglePasswordConfirmationError(!it)
        }
    }

    fun onActionBtnClick() = if(isSignInMode) signIn() else signUp()

    private fun signIn(){
        if(!pickerState.areLoginFieldsValid){
            viewState.showCompleteFieldsWarning()
            return
        }
    }

    private fun signUp(){
        if(!pickerState.areRegistrationFieldsValid){
            viewState.showCompleteFieldsWarning()
            return
        }
    }

    data class PickerState(
        val userName: ValidatableField<String>,
        val birthDate: ValidatableField<LocalDate>,
        val phoneNumber: ValidatableField<String>,
        val email: ValidatableField<String>,
        val password: ValidatableField<String>,
        var confirmPassword: ComparingValidatableField<String>,
    ){
        val areRegistrationFieldsValid: Boolean
            get() = userName.isValid && birthDate.isValid && email.isValid
                    && phoneNumber.isValid && password.isValid && confirmPassword.isValid
        val areLoginFieldsValid: Boolean
            get() = email.isValid && password.isValid
    }
}