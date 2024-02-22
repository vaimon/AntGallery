package me.vaimon.antgallery.ui.home.nested_ui.picture_viewer.viewpager_fragments

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
sealed class PicturesCategory: Parcelable {
    data object New : PicturesCategory()
    data object Popular : PicturesCategory()
}