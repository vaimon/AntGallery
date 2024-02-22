package me.vaimon.antgallery.ui.home.nested_ui.picture_viewer.viewpager_fragments

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.vaimon.antgallery.data.mapper.Mapper
import me.vaimon.antgallery.domain.entity.PictureEntity
import me.vaimon.antgallery.domain.usecase.GetNewPicturesUseCase
import me.vaimon.antgallery.domain.usecase.GetPopularPicturesUseCase
import me.vaimon.antgallery.models.Picture
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

class PicturesPresenter @Inject constructor(
    private val getNewPicturesUseCase: GetNewPicturesUseCase,
    private val getPopularPicturesUseCase: GetPopularPicturesUseCase,
    private val pictureMapper: Mapper<Picture, PictureEntity>
) : MvpPresenter<PicturesView>() {
    private var picturesCategory: PicturesCategory? = null

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        updatePictures()
    }

    fun setCategory(category: PicturesCategory): PicturesPresenter{
        picturesCategory = category
        return this
    }

    private fun updatePictures(){
        presenterScope.launch(Dispatchers.Main) {
            viewState.showLoading()
            val pictures = when(picturesCategory){
                is PicturesCategory.New -> getNewPicturesUseCase()
                is PicturesCategory.Popular -> getPopularPicturesUseCase()
                else -> throw IllegalStateException("Invalid pictures category")
            }.map {
                pictureMapper.from(it)
            }
            if (pictures.isEmpty())
                viewState.showError()
            else
                viewState.setPictures(pictures)
        }
    }
}