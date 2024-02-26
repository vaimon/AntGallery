package me.vaimon.antgallery.ui.home.nested_ui.profile

import moxy.MvpView
import moxy.viewstate.strategy.alias.OneExecution

interface ProfileView: MvpView {
    @OneExecution
    fun navigateToWelcomeScreen()
}