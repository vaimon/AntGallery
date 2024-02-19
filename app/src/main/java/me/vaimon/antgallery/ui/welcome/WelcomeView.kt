package me.vaimon.antgallery.ui.welcome

import me.vaimon.antgallery.utils.AppConstants
import moxy.MvpView
import moxy.viewstate.strategy.alias.OneExecution

interface WelcomeView: MvpView {

    @OneExecution
    fun navigateToAuthScreen(authType: AppConstants.AuthType)
}