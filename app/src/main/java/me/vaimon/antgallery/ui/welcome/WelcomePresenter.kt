package me.vaimon.antgallery.ui.welcome

import me.vaimon.antgallery.utils.AppConstants
import moxy.MvpPresenter

class WelcomePresenter: MvpPresenter<WelcomeView>() {

    fun onBtnSignInClick(){
        viewState.navigateToAuthScreen(AppConstants.AuthType.SignIn)
    }

    fun onBtnSignUpClick(){
        viewState.navigateToAuthScreen(AppConstants.AuthType.SignUp)
    }
}