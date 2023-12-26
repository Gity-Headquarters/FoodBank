package com.gity.foodbank.ui.fragment.donate

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gity.foodbank.R

class DonateFragment : Fragment() {

    companion object {
        fun newInstance() = DonateFragment()
    }

    private lateinit var viewModel: DonateViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_donate, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DonateViewModel::class.java)
        // TODO: Use the ViewModel
    }

}