package me.vaimon.antgallery.ui.home

import moxy.MvpView
import moxy.viewstate.strategy.alias.OneExecution

interface HomeView: MvpView {
    @OneExecution
    fun navigateToWelcomeScreen()
}