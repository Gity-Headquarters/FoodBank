package com.gity.foodbank.ui.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gity.foodbank.R
import com.gity.foodbank.data.adapter.ListItemBoothAdapter
import com.gity.foodbank.data.model.ListItemBooth
import com.gity.foodbank.databinding.FragmentHomeBinding
import com.gity.foodbank.utils.Common

@Suppress("DEPRECATION")
class HomeFragment : Fragment(), ListItemBoothAdapter.ItemClickListener {

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

        val resource = requireActivity().resources

        val stringArrayTitle = resource.getStringArray(R.array.list_item_booth_title)
        val stringArrayFoods = resource.getStringArray(R.array.list_item_booth_food)
        val stringArrayLocation = resource.getStringArray(R.array.list_item_booth_location)
        val stringArrayTime = resource.getStringArray(R.array.list_item_booth_time)

        val listItemBooth = listOf(
            ListItemBooth(R.drawable.foodbank1, stringArrayTitle[0], stringArrayFoods[0], stringArrayLocation[0], stringArrayTime[0]),
            ListItemBooth(R.drawable.foodbank2, stringArrayTitle[1], stringArrayFoods[1], stringArrayLocation[1], stringArrayTime[1]),
            ListItemBooth(R.drawable.foodbank3, stringArrayTitle[2], stringArrayFoods[2], stringArrayLocation[2], stringArrayTime[2]),
            ListItemBooth(R.drawable.foodbank4, stringArrayTitle[3], stringArrayFoods[3], stringArrayLocation[3], stringArrayTime[3]),
            ListItemBooth(R.drawable.foodbank5, stringArrayTitle[4], stringArrayFoods[4], stringArrayLocation[4], stringArrayTime[4])
        )

        val recyclerView: RecyclerView = binding.rvListItemBooth
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = ListItemBoothAdapter(listItemBooth, this)

        binding.apply {
            btnDonate.setOnClickListener {
                Common.showToast(requireContext(), "Button Donate Clicked")
            }

            itemMenuDonation.setOnClickListener {
                Common.showToast(requireContext(), "Item menu Donation Clicked")
            }

            itemMenuVolunteer.setOnClickListener {
                Common.showToast(requireContext(), "Item menu Volunteer Clicked")
            }

            itemMenuCollaborate.setOnClickListener {
                Common.showToast(requireContext(), "Item menu Collaborate Clicked")
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

    override fun onItemClick(position: Int) {
        Common.showToast(requireContext(), "Item ke ${position + 1} di klik, ini akan mengarah ke halaman detail")
    }

}