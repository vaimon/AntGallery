package me.vaimon.antgallery.ui.home.nested_ui.picture_viewer.fragments

import me.vaimon.antgallery.models.Picture
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface PicturesView: MvpView {
    @AddToEndSingle
    fun setPictures(newPictures: List<Picture>)

    @AddToEndSingle
    fun showError()

    @AddToEndSingle
    fun showLoading()
}