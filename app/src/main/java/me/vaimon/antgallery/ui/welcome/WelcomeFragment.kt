package me.vaimon.antgallery.ui.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import me.vaimon.antgallery.R
import me.vaimon.antgallery.databinding.FragmentWelcomeBinding
import me.vaimon.antgallery.utils.AppConstants
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import moxy.presenter.InjectPresenter
import javax.inject.Inject
import javax.inject.Provider


@AndroidEntryPoint
class WelcomeFragment: MvpAppCompatFragment(), WelcomeView {
    private lateinit var binding: FragmentWelcomeBinding

    @InjectPresenter
    lateinit var presenter: WelcomePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupListeners()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setupListeners() {
        binding.btnSignIn.setOnClickListener {
            presenter.onBtnSignInClick()
        }
        binding.btnSignUp.setOnClickListener {
            presenter.onBtnSignUpClick()
        }
    }

    override fun navigateToAuthScreen(authType: AppConstants.AuthType) {
        val action = WelcomeFragmentDirections.actionWelcomeToAuthorization(authType)
        findNavController().navigate(action)
    }
}