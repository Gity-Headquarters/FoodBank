package com.gity.foodbank.ui.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.gity.foodbank.databinding.FragmentHomeBinding
import com.gity.foodbank.utils.CommonUtils

@Suppress("DEPRECATION")
class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        binding.apply {
            btnDonate.setOnClickListener {
                CommonUtils.showToast(requireContext(), "Button Donate Clicked")
            }

            itemMenuDonation.setOnClickListener {
                CommonUtils.showToast(requireContext(), "Item menu Donation Clicked")
            }

            itemMenuVolunteer.setOnClickListener {
                CommonUtils.showToast(requireContext(), "Item menu Volunteer Clicked")
            }

            itemMenuCollaborate.setOnClickListener {
                CommonUtils.showToast(requireContext(), "Item menu Collaborate Clicked")
            }
        }

    }

    companion object {
        fun newInstance(): HomeFragment {
            val fragment = HomeFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

}