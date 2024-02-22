package me.vaimon.antgallery.ui.home.nested_ui.picture_viewer.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import me.vaimon.antgallery.ui.home.nested_ui.picture_viewer.viewpager_fragments.PicturesCategory
import me.vaimon.antgallery.ui.home.nested_ui.picture_viewer.viewpager_fragments.PicturesFragment

class PictureViewerTabAdapter(hostFragment: Fragment) : FragmentStateAdapter(
    hostFragment.childFragmentManager,
    hostFragment.lifecycle
) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> PicturesFragment.newInstance(PicturesCategory.New)
            1 -> PicturesFragment.newInstance(PicturesCategory.Popular)
            else -> throw IllegalStateException("Invalid tab position")
        }
    }
}