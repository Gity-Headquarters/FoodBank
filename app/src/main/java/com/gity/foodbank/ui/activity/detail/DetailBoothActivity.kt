package com.gity.foodbank.ui.activity.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.gity.foodbank.R
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

        val guid = getDetailId()

        if (guid != null) {
            viewModel.getBoothDetail(guid)
        }

        viewModel.boothDetail.observe(this@DetailBoothActivity) { detailData ->
            if (detailData != null) {
                binding.apply {
                    Glide.with(this@DetailBoothActivity)

                        .load(detailData.data?.image)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .centerCrop()
                        .into(ivBoothImage)

                    tvBoothTitle.text = detailData.data?.name

                    val statusBooth = detailData.data?.status

                    if (statusBooth == "open") {
                        tvBoothStatus.text = "Open"
                        tvBoothStatus.setTextColor(getColor(R.color.dark_green))
                        lineStatusColor.setImageDrawable(getDrawable(R.drawable.ic_green_line))

                    } else if (statusBooth == "close") {
                        tvBoothStatus.text = "Close"
                        tvBoothStatus.setTextColor(getColor(R.color.dark_red))
                        lineStatusColor.setImageDrawable(getDrawable(R.drawable.ic_red_line))
                    }

                    tvBoothLocation.text = detailData.data?.address
                    tvBoothFoods.text = detailData.data?.foodTotal.toString()
                    tvBoothTimeOpen.text = detailData.data?.timeOpen
                    tvBoothTimeClose.text = detailData.data?.timeClose
                    tvBoothDescription.text = detailData.data?.description
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