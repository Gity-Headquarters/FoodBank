package com.gity.foodbank.ui.activity.detail

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.gity.foodbank.databinding.ActivityDetailBoothBinding
import com.gity.foodbank.di.Injection
import com.gity.foodbank.factory.ViewModelFactory
import com.gity.foodbank.utils.Common

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

        viewModel.boothDetail.observe(this@DetailBoothActivity) { detailData ->

            if (detailData != null) {
                binding.apply {
                    Glide.with(this@DetailBoothActivity)
                        .load(detailData.image)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .centerCrop()
                        .into(ivBoothImage)

                    tvBoothTitle.text = detailData.name
                    tvBoothStatus.text = detailData.status
                    tvBoothLocation.text = detailData.address
                    tvBoothFoods.text = detailData.foodTotal.toString()
                    tvBoothTimeOpen.text = detailData.timeOpen
                    tvBoothTimeClose.text = detailData.timeClose
                    tvBoothDescription.text = detailData.description
                }
            }

        }

            getDetailId()
        Common.showToast(this, "GUID : ${getDetailId()}")
    }

    private fun getDetailId(): String? {
        val guid = intent.getStringExtra("extra_id")
        if (guid != null) {
            viewModel.getBoothDetail(guid)
        }
        return guid
    }
}