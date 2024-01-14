package com.gity.foodbank.data.adapter.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gity.foodbank.R
import com.gity.foodbank.data.model.ListItemOtherDonations

class ListItemOtherDonationsAdapter(private val listItem: List<ListItemOtherDonations>, private val itemClickListener: ItemClickListener) :
    RecyclerView.Adapter<ListItemOtherDonationsAdapter.ItemAdapter>() {

        interface ItemClickListener {
            fun onItemClick(position: Int)
        }

    class ItemAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imageOtherDonations: ImageView = itemView.findViewById(R.id.iv_other_donations_image)
        private val titleOtherDonations: TextView = itemView.findViewById(R.id.tv_other_donations_title)
        private val descriptionOtherDonations: TextView = itemView.findViewById(R.id.tv_other_donations_description)

        fun bind(item: ListItemOtherDonations) {
            imageOtherDonations.setImageResource(item.imageResId)
            titleOtherDonations.text = item.title
            descriptionOtherDonations.text = item.description
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_other_donations, parent, false)
        return ItemAdapter(view)
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    override fun onBindViewHolder(holder: ItemAdapter, position: Int) {
        val item = listItem[position]
        holder.bind(item)

        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(position)
        }
    }

}