package me.vaimon.antgallery.ui.home.nested_ui.picture_viewer.viewpager_fragments

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.parcelize.Parcelize
import me.vaimon.antgallery.R
import me.vaimon.antgallery.databinding.FragmentPicturesBinding
import me.vaimon.antgallery.models.Picture
import me.vaimon.antgallery.ui.home.nested_ui.picture_viewer.adapters.PictureRecyclerViewAdapter
import me.vaimon.antgallery.utils.ui.ItemOffsetDecoration
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

@AndroidEntryPoint
class PicturesFragment : MvpAppCompatFragment(), PicturesView {

    companion object{
        fun newInstance(category: PicturesCategory): PicturesFragment{
            val fragment = PicturesFragment()

            val args = Bundle()
            args.putParcelable("category", category)
            fragment.arguments = args

            return fragment
        }
    }

    private lateinit var binding: FragmentPicturesBinding
    private val pictureAdapter by lazy { PictureRecyclerViewAdapter() }

    @Inject
    @InjectPresenter
    lateinit var presenter: PicturesPresenter

    @Suppress("DEPRECATION")
    @ProvidePresenter
    fun providePresenter(): PicturesPresenter {
        return presenter.setCategory(
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    arguments?.getParcelable("category", PicturesCategory::class.java)
                } else {
                    arguments?.getParcelable("category") as PicturesCategory?
                } ?: throw IllegalArgumentException("Fragment must be provided with a category")
            )
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
    }

    private fun setupRecyclerView(){
        binding.rvPictures.apply {
            adapter = pictureAdapter
            layoutManager = GridLayoutManager(context,2)
            addItemDecoration(ItemOffsetDecoration(context, R.dimen.gridSpacing))
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