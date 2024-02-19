package me.vaimon.antgallery.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import me.vaimon.antgallery.R
import me.vaimon.antgallery.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}