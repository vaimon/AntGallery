package me.vaimon.antgallery.ui.authorization

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.vaimon.antgallery.R
import me.vaimon.antgallery.databinding.FragmentAuthorizationBinding

class AuthorizationFragment : Fragment() {
    private lateinit var binding: FragmentAuthorizationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthorizationBinding.inflate(inflater, container, false)
        return binding.root
    }
}