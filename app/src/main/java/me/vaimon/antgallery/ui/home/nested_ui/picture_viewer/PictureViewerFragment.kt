package me.vaimon.antgallery.ui.home.nested_ui.picture_viewer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import me.vaimon.antgallery.R
import me.vaimon.antgallery.databinding.FragmentPictureViewerBinding
import me.vaimon.antgallery.models.Picture
import me.vaimon.antgallery.ui.home.nested_ui.picture_viewer.adapters.PictureViewerTabAdapter
import moxy.MvpAppCompatFragment

class PictureViewerFragment : MvpAppCompatFragment(), PictureViewerView {
    private lateinit var binding: FragmentPictureViewerBinding

    private var tabAdapter: PictureViewerTabAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPictureViewerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapters()
        setupTabLayout()
    }

    private fun setupAdapters() {
        tabAdapter = PictureViewerTabAdapter(this)
    }

    private fun setupTabLayout(){
        binding.viewPager.apply {
            adapter = tabAdapter
            TabLayoutMediator(binding.tabLayout,this) { tab, position ->
                tab.text = when(position){
                    0 -> getString(R.string.tab_new)
                    1 -> getString(R.string.tab_popular)
                    else -> throw IllegalStateException("There must be only 2 tabs!")
                }
            }.attach()
        }

    }

}