package me.vaimon.antgallery.ui.authorization

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import me.vaimon.antgallery.R
import me.vaimon.antgallery.databinding.FragmentAuthorizationBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale
import javax.inject.Inject
import javax.inject.Provider


@AndroidEntryPoint
class AuthorizationFragment : MvpAppCompatFragment(), AuthorizationView {
    private lateinit var binding: FragmentAuthorizationBinding

    private val navigationArgs: AuthorizationFragmentArgs by navArgs()

    @Inject
    @InjectPresenter
    lateinit var presenter: AuthorizationPresenter

    @ProvidePresenter
    fun providePresenter(): AuthorizationPresenter {
        return presenter
    }

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
        setupEditTexts()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setupListeners() {
        binding.btnChangeMode.setOnClickListener {
            presenter.onToggleAuthType()
        }

        binding.etBirthday.keyListener = null
        binding.etBirthday.setOnClickListener {
            presenter.onBirthdayClicked()
        }

        binding.btnAct.setOnClickListener {
            presenter.onActionBtnClick()
        }
    }

    private fun setupToolbar(){
        binding.btnNavigateUp.setOnClickListener {
            presenter.onNavigateUp()
        }
    }

    private fun setupEditTexts() {
        binding.etUsername.doOnTextChanged { text, _, _, _ ->
            presenter.onUsernameChanged(text?.toString())
        }
        binding.etEmail.doOnTextChanged { text, _, _, _ ->
            presenter.onEmailChanged(text?.toString())
        }
        binding.etPhone.doOnTextChanged { text, _, _, _ ->
            presenter.onPhoneChanged(text?.toString())
        }
        binding.etPassword.doOnTextChanged { text, _, _, _ ->
            presenter.onPasswordChanged(text?.toString())
        }
        binding.etConfirmPassword.doOnTextChanged { text, _, _, _ ->
            presenter.onPasswordConfirmationChanged(text?.toString())
        }
    }

    override fun openDatePicker(){
        val picker = MaterialDatePicker.Builder.datePicker().apply {
            setTitleText(R.string.select_birthday)
        }.build()
        picker.addOnPositiveButtonClickListener {
            presenter.onBirthDayPicked(it)
        }
        picker.show(this.parentFragmentManager, "DATE_PICKER")
    }

    override fun updateDate(date: LocalDate?) {
        binding.etBirthday.setText(date?.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
         ?: "")
    }

    override fun toggleUserNameError(shouldShow: Boolean) {
        binding.tilUsername.apply {
            isErrorEnabled = shouldShow
            error = if(shouldShow) getString(R.string.error_username) else null
        }
    }

    override fun toggleBirthDayError(shouldShow: Boolean) {
        binding.tilBirthday.apply {
            isErrorEnabled = shouldShow
            error = if(shouldShow) getString(R.string.error_birthday) else null
        }
    }

    override fun togglePhoneError(shouldShow: Boolean) {
        binding.tilPhone.apply {
            isErrorEnabled = shouldShow
            error = if(shouldShow) getString(R.string.error_phone) else null
        }
    }

    override fun toggleEmailError(shouldShow: Boolean) {
        binding.tilEmail.apply {
            isErrorEnabled = shouldShow
            error = if(shouldShow) getString(R.string.error_email) else null
        }
    }

    override fun togglePasswordError(shouldShow: Boolean) {
        binding.tilPassword.apply {
            isErrorEnabled = shouldShow
            error = if(shouldShow) getString(R.string.error_password) else null
        }
    }

    override fun togglePasswordConfirmationError(shouldShow: Boolean) {
        binding.tilConfirmPassword.apply {
            isErrorEnabled = shouldShow
            error = if(shouldShow) getString(R.string.error_password_confirmation) else null
        }
    }

    override fun showCompleteFieldsWarning() {
        Toast.makeText(context, getString(R.string.warning_input), Toast.LENGTH_SHORT).show()
    }

    override fun updateUiType(isSignInMode: Boolean) {
        binding.groupRegistrationFields.isVisible = !isSignInMode

        if (isSignInMode) {
            binding.btnAct.text = getString(R.string.sign_in)
            binding.btnChangeMode.text = getString(R.string.sign_up)
            binding.tvHeader.text = getString(R.string.sign_in_header)
            binding.tilEmail.hint = getText(R.string.email)
            binding.tilPassword.hint = getText(R.string.password)
        } else{
            binding.btnAct.text = getString(R.string.sign_up)
            binding.btnChangeMode.text = getString(R.string.sign_in)
            binding.tvHeader.text = getString(R.string.sign_up_header)
            binding.tilEmail.hint = getText(R.string.email_req)
            binding.tilPassword.hint = getText(R.string.password_req)
        }
    }

    override fun onNavigateUp() {
        findNavController().navigateUp()
    }
}