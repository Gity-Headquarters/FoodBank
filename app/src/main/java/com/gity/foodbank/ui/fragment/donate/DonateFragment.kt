package com.gity.foodbank.ui.fragment.donate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gity.foodbank.R
import com.gity.foodbank.data.adapter.recycler.ListItemOtherDonationsAdapter
import com.gity.foodbank.data.model.ListItemOtherDonations
import com.gity.foodbank.databinding.FragmentDonateBinding
import com.gity.foodbank.utils.Common

@Suppress("DEPRECATION")
class DonateFragment : Fragment(), ListItemOtherDonationsAdapter.ItemClickListener {

    private lateinit var viewModel: DonateViewModel
    private lateinit var binding: FragmentDonateBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDonateBinding.inflate(inflater, container, false)
        return binding.root
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[DonateViewModel::class.java]


        val resources = requireActivity().resources

        val stringArrayTitle = resources.getStringArray(R.array.list_item_other_donations_title)
        val stringArrayDescriptoin =
            resources.getStringArray(R.array.list_item_other_donations_description)

        val listItemOtherDonations = listOf(
            ListItemOtherDonations(
                R.drawable.foodbank1,
                stringArrayTitle[0],
                stringArrayDescriptoin[0]
            ),
            ListItemOtherDonations(
                R.drawable.foodbank2,
                stringArrayTitle[1],
                stringArrayDescriptoin[1]
            ),
            ListItemOtherDonations(
                R.drawable.foodbank3,
                stringArrayTitle[2],
                stringArrayDescriptoin[2]
            ),
            ListItemOtherDonations(
                R.drawable.foodbank4,
                stringArrayTitle[3],
                stringArrayDescriptoin[3]
            ),
            ListItemOtherDonations(
                R.drawable.foodbank5,
                stringArrayTitle[4],
                stringArrayDescriptoin[4]
            ),
        )

        val recyclerView: RecyclerView = binding.rvListItemOtherDonations
        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = ListItemOtherDonationsAdapter(listItemOtherDonations, this)

    }

    companion object {
        fun newInstance(): DonateFragment {
            val fragment = DonateFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onItemClick(position: Int) {
        Common.showToast(
            requireContext(),
            "Item ke ${position + 1} di klik, ini akan mengarah ke halaman detail"
        )
    }

}