package me.vaimon.antgallery.ui.authorization

import me.vaimon.antgallery.utils.AppConstants
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.OneExecution
import java.time.LocalDate
import java.util.Date

interface AuthorizationView: MvpView {

    @AddToEndSingle
    fun updateUiType(isSignInMode: Boolean)

    @OneExecution
    fun onNavigateUp()
    @OneExecution
    fun openDatePicker()
    @OneExecution
    fun updateDate(date: LocalDate?)
    @AddToEndSingle
    fun toggleUserNameError(shouldShow: Boolean)
    @AddToEndSingle
    fun toggleBirthDayError(shouldShow: Boolean)
    @AddToEndSingle
    fun togglePhoneError(shouldShow: Boolean)
    @AddToEndSingle
    fun toggleEmailError(shouldShow: Boolean)
    @AddToEndSingle
    fun togglePasswordError(shouldShow: Boolean)
    @AddToEndSingle
    fun togglePasswordConfirmationError(shouldShow: Boolean)
    @OneExecution
    fun showCompleteFieldsWarning()
}