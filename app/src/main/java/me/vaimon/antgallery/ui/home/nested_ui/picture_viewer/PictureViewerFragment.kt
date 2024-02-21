package me.vaimon.antgallery.ui.home.nested_ui.picture_viewer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import me.vaimon.antgallery.databinding.FragmentPictureViewerBinding
import me.vaimon.antgallery.ui.home.nested_ui.picture_viewer.adapters.PictureViewerTabAdapter

class PictureViewerFragment : Fragment() {
    private lateinit var binding: FragmentPictureViewerBinding

    private val tabAdapter by lazy {PictureViewerTabAdapter(this)}
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPictureViewerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupTabLayout()
    }

    private fun setupTabLayout(){
        binding.viewPager.apply {
            adapter = tabAdapter
            TabLayoutMediator(binding.tabLayout,this) { _, _ -> }.attach()
        }

    }

}