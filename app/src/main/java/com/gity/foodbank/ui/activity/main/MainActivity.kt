package com.gity.foodbank.ui.activity.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.gity.foodbank.R
import com.gity.foodbank.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        Disable DarkMode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        setupBottomNav()
    }

    private fun setupBottomNav() {
        binding.bottomNav.setOnItemSelectedListener {
            when (it) {
                R.id.bottom_nav_menu_home -> binding.tvWelcom.text = "Welcome"
                R.id.bottom_nav_menu_explore -> binding.tvWelcom.text = "Explore"
                R.id.bottom_nav_menu_profile -> binding.tvWelcom.text = "Profile"
            }
        }
    }
}