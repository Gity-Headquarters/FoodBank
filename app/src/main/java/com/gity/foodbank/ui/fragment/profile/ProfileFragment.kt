package com.gity.foodbank.ui.fragment.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.gity.foodbank.data.preferences.datastore.DataStore
import com.gity.foodbank.data.preferences.datastore.dataStore
import com.gity.foodbank.databinding.FragmentProfileBinding
import com.gity.foodbank.ui.activity.session.SplashActivity
import kotlinx.coroutines.launch

@Suppress("DEPRECATION")
class ProfileFragment : Fragment() {

    private lateinit var viewModel: ProfileViewModel
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]

        binding.apply {
            btnLogout.setOnClickListener {
                lifecycleScope.launch {
                    logout()
                    requireActivity().supportFragmentManager.popBackStack(
                        null,
                        FragmentManager.POP_BACK_STACK_INCLUSIVE
                    )
                    requireActivity().finish()
                    startActivity(Intent(requireActivity(), SplashActivity::class.java))
                }
            }

            


//            Glide.with(requireContext())
//                .load(detailData.image)
//                .transition(DrawableTransitionOptions.withCrossFade())
//                .centerCrop()
//                .into(ivUserProfile)

        }
    }

    private suspend fun logout() {
        val dataStore = DataStore.getInstance(requireActivity().dataStore)
        dataStore.clearToken()
    }


    companion object {
        fun newInstance(): ProfileFragment {
            val fragment = ProfileFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

}