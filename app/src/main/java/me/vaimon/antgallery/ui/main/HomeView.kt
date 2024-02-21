package me.vaimon.antgallery.ui.main

import moxy.MvpView
import moxy.viewstate.strategy.alias.OneExecution

interface HomeView: MvpView {
    @OneExecution
    fun navigateToWelcomeScreen()
}