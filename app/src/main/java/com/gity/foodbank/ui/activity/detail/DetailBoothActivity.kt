package com.gity.foodbank.ui.activity.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.gity.foodbank.databinding.ActivityDetailBoothBinding
import com.gity.foodbank.di.Injection
import com.gity.foodbank.factory.ViewModelFactory

class DetailBoothActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBoothBinding
    private lateinit var viewModel: DetailBoothViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBoothBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val injection = Injection.provideRepository()
        val viewModelFactory = ViewModelFactory(injection)
        viewModel = ViewModelProvider(this, viewModelFactory)[DetailBoothViewModel::class.java]


    }
}