package me.vaimon.antgallery.ui.main

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.vaimon.antgallery.domain.usecase.GetLoggedUserIdUseCase
import moxy.MvpPresenter
import moxy.presenterScope
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