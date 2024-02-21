package me.vaimon.antgallery.ui.home

import me.vaimon.antgallery.domain.usecase.GetLoggedUserIdUseCase
import moxy.MvpPresenter
import javax.inject.Inject

class HomePresenter @Inject constructor(
    private val getLoggedUserIdUseCase: GetLoggedUserIdUseCase
): MvpPresenter<HomeView>() {

    fun checkAuthStatus(){
        getLoggedUserIdUseCase() ?: run{
            viewState.navigateToWelcomeScreen()
        }
    }
}