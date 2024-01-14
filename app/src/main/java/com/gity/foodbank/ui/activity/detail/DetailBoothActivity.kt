package com.gity.foodbank.ui.activity.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.gity.foodbank.R
import com.gity.foodbank.data.preferences.datastore.DataStore
import com.gity.foodbank.data.preferences.datastore.dataStore
import com.gity.foodbank.databinding.ActivityDetailBoothBinding
import com.gity.foodbank.di.Injection
import com.gity.foodbank.factory.ViewModelFactory
import com.gity.foodbank.utils.Common
import kotlinx.coroutines.launch

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

        binding.btnBack.setOnClickListener {
            finish()
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
                        tvBoothStatus.text = getString(R.string.openBooth)
                        tvBoothStatus.setTextColor(getColor(R.color.dark_green))
                        val drawableImageGreenLine = ContextCompat.getDrawable(
                            this@DetailBoothActivity,
                            R.drawable.ic_green_line
                        )
                        lineStatusColor.setImageDrawable(drawableImageGreenLine)

                    } else if (statusBooth == "close") {
                        tvBoothStatus.text = getString(R.string.closeBooth)
                        tvBoothStatus.setTextColor(getColor(R.color.dark_red))
                        val drawableImageRedLine = ContextCompat.getDrawable(
                            this@DetailBoothActivity,
                            R.drawable.ic_red_line
                        )
                        lineStatusColor.setImageDrawable(drawableImageRedLine)
                    }

                    tvBoothLocation.text = detailData.data?.address
                    tvBoothFoods.text = detailData.data?.foodTotal.toString()
                    tvBoothTimeOpen.text = detailData.data?.timeOpen
                    tvBoothTimeClose.text = detailData.data?.timeClose
                    tvBoothDescription.text = detailData.data?.description
                    val boothGuid = detailData.data?.guid

                    lifecycleScope.launch {
                        val guid = getGuidUser()
                        binding.btnTakeFood.setOnClickListener {
                            Common.showToast(this@DetailBoothActivity, "User GUID : $guid, Booth Guid : $boothGuid")
                        }
                    }

                }


            }

        }



        getDetailId()
    }

    private suspend fun getGuidUser(): String {
        val dataStore = DataStore.getInstance(this@DetailBoothActivity.dataStore)
        return dataStore.getGuidUser()
    }

    private fun getDetailId(): String? {
        val guid = intent.getStringExtra("extra_id")
        if (guid != null) {
            viewModel.getBoothDetail(guid)
        }
        return guid
    }
}