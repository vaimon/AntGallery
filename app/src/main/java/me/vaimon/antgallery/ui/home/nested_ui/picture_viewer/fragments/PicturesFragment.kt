package me.vaimon.antgallery.ui.home.nested_ui.picture_viewer.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import me.vaimon.antgallery.databinding.FragmentPicturesBinding
import me.vaimon.antgallery.models.Picture
import me.vaimon.antgallery.ui.home.nested_ui.picture_viewer.adapters.PictureRecyclerViewAdapter
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

@AndroidEntryPoint
class PicturesFragment : MvpAppCompatFragment(), PicturesView {

    private lateinit var binding: FragmentPicturesBinding
    private val pictureAdapter by lazy { PictureRecyclerViewAdapter() }

    @Inject
    @InjectPresenter
    lateinit var presenter: PicturesPresenter

    @ProvidePresenter
    fun providePresenter(): PicturesPresenter {
        return presenter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPicturesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        presenter.updatePictures()
    }

    private fun setupRecyclerView(){
        binding.rvPictures.apply {
            adapter = pictureAdapter
            layoutManager = GridLayoutManager(context,2)
        }
    }

    private fun toggleVisibility(
        isListVisible: Boolean = false,
        isLoadingVisible: Boolean = false,
        isErrorVisible: Boolean = false
    ){
        binding.rvPictures.isVisible = isListVisible
        binding.progressBar.isVisible = isLoadingVisible
        binding.errorBar.isVisible = isErrorVisible
    }

    override fun setPictures(newPictures: List<Picture>) {
        showPictureList()
        pictureAdapter.replaceWithNewPictures(newPictures)
    }

    override fun showError() = toggleVisibility(isErrorVisible = true)

    override fun showLoading() = toggleVisibility(isLoadingVisible = true)

    private fun showPictureList() = toggleVisibility(isListVisible = true)
}