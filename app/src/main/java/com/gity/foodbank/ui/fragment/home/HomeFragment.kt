package com.gity.foodbank.ui.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gity.foodbank.data.adapter.recycler.BoothAdapter
import com.gity.foodbank.databinding.FragmentHomeBinding
import com.gity.foodbank.di.Injection
import com.gity.foodbank.factory.ViewModelFactory
import com.gity.foodbank.utils.Common

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: BoothAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repository = Injection.provideRepository()
        val viewModelFactory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]


        adapter =
            BoothAdapter() //  Inisiasi dengan emptyList atau List Kosong dulu
        val recyclerView: RecyclerView = binding.rvListItemBooth
        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter

        viewModel.getBooths()

        viewModel.booths.observe(viewLifecycleOwner) { booths ->
            adapter.setData(booths)
        }

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

}