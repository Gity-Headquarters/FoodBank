package com.gity.foodbank.ui.activity.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gity.foodbank.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}