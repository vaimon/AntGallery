package me.vaimon.antgallery.ui.home.nested_ui.picture_viewer.fragments

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.vaimon.antgallery.data.mapper.Mapper
import me.vaimon.antgallery.domain.entity.PictureEntity
import me.vaimon.antgallery.domain.usecase.GetNewPicturesUseCase
import me.vaimon.antgallery.models.Picture
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

class PicturesPresenter @Inject constructor(
    private val getNewPicturesUseCase: GetNewPicturesUseCase,
    private val pictureMapper: Mapper<Picture, PictureEntity>
) : MvpPresenter<PicturesView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        updatePictures()
    }

    fun updatePictures(){
        presenterScope.launch(Dispatchers.Main) {
            viewState.showLoading()
            val pictures = getNewPicturesUseCase().map {
                pictureMapper.from(it)
            }
            if (pictures.isEmpty())
                viewState.showError()
            else
                viewState.setPictures(pictures)
        }
    }
}