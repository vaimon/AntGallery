package me.vaimon.antgallery.ui.authorization

import me.vaimon.antgallery.utils.AppConstants
import moxy.MvpPresenter

class AuthorizationPresenter: MvpPresenter<AuthorizationView>() {

    private var isSignInMode = false

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
}