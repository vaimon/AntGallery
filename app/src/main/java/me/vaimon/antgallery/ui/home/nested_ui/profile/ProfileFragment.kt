package me.vaimon.antgallery.ui.home.nested_ui.profile

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import me.vaimon.antgallery.R
import me.vaimon.antgallery.databinding.FragmentProfileBinding
import me.vaimon.antgallery.ui.home.nested_ui.picture_viewer.viewpager_fragments.PicturesCategory
import me.vaimon.antgallery.ui.home.nested_ui.picture_viewer.viewpager_fragments.PicturesPresenter
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

@AndroidEntryPoint
class ProfileFragment : MvpAppCompatFragment(), ProfileView {
    private lateinit var binding: FragmentProfileBinding

    @Inject
    @InjectPresenter
    lateinit var presenter: ProfilePresenter

    @ProvidePresenter
    fun providePresenter(): ProfilePresenter {
        return presenter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
//        binding.toolbar.inflateMenu(R.menu.profile_menu)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.menu_action_settings -> {
                    presenter.onSettingsToolbarButtonClick()
                    true
                }
                else -> false
            }
        }
    }

    override fun navigateToWelcomeScreen() {
        requireActivity().recreate()
    }
}