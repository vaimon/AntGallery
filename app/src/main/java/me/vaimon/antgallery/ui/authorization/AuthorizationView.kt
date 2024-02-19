package me.vaimon.antgallery.ui.authorization

import me.vaimon.antgallery.utils.AppConstants
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.OneExecution

interface AuthorizationView: MvpView {

    @AddToEndSingle
    fun updateUiType(isSignInMode: Boolean)

    @OneExecution
    fun onNavigateUp()

}