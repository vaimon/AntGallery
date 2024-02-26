package me.vaimon.antgallery.ui.home.nested_ui.profile

import me.vaimon.antgallery.domain.usecase.UserSignOutUseCase
import moxy.MvpPresenter
import javax.inject.Inject

class ProfilePresenter @Inject constructor(
    private val signOutUseCase: UserSignOutUseCase
): MvpPresenter<ProfileView>() {

    fun onSettingsToolbarButtonClick(){
        signOutUseCase()
        viewState.navigateToWelcomeScreen()
    }
}