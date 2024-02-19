package me.vaimon.antgallery.ui.authorization

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import me.vaimon.antgallery.R
import me.vaimon.antgallery.databinding.FragmentAuthorizationBinding
import me.vaimon.antgallery.utils.AppConstants
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class AuthorizationFragment : MvpAppCompatFragment(), AuthorizationView {
    private lateinit var binding: FragmentAuthorizationBinding

    private val navigationArgs: AuthorizationFragmentArgs by navArgs()

    @InjectPresenter
    lateinit var presenter: AuthorizationPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthorizationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.setAuthType(navigationArgs.authType)
        setupListeners()
        setupToolbar()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setupListeners() {
        binding.btnChangeMode.setOnClickListener {
            presenter.onToggleAuthType()
        }
    }

    private fun setupToolbar(){
        binding.btnNavigateUp.setOnClickListener {
            presenter.onNavigateUp()
        }
    }

    override fun updateUiType(isSignInMode: Boolean) {
        binding.groupRegistrationFields.isVisible = !isSignInMode

        if (isSignInMode) {
            binding.btnAct.text = getString(R.string.sign_in)
            binding.btnChangeMode.text = getString(R.string.sign_up)
            binding.tvHeader.text = getString(R.string.sign_in_header)
            binding.tilEmail.hint = getString(R.string.email)
            binding.tilPassword.hint = getString(R.string.password)
        } else{
            binding.btnAct.text = getString(R.string.sign_up)
            binding.btnChangeMode.text = getString(R.string.sign_in)
            binding.tvHeader.text = getString(R.string.sign_up_header)
            binding.tilEmail.hint = getString(R.string.email_req)
            binding.tilPassword.hint = getString(R.string.password_req)
        }
    }

    override fun onNavigateUp() {
        findNavController().navigateUp()
    }
}