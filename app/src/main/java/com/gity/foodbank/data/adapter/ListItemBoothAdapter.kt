package com.gity.foodbank.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gity.foodbank.R
import com.gity.foodbank.data.model.ListItemBooth

class ListItemBoothAdapter(private val listItem: List<ListItemBooth>, private val itemClickListener: ItemClickListener) :
    RecyclerView.Adapter<ListItemBoothAdapter.ItemAdapter>() {

        interface ItemClickListener {
            fun onItemClick(position: Int)
        }

    class ItemAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imageBooth: ImageView = itemView.findViewById(R.id.iv_booth_image)
        private val titleBooth: TextView = itemView.findViewById(R.id.tv_booth_title)
        private val foodsBooth: TextView = itemView.findViewById(R.id.tv_booth_foods)
        private val locationBooth: TextView = itemView.findViewById(R.id.tv_booth_location)
        private val timeBooth: TextView = itemView.findViewById(R.id.tv_booth_time)

        fun bind(item: ListItemBooth) {
            imageBooth.setImageResource(item.imageResId)
            titleBooth.text = item.title
            foodsBooth.text = item.foods
            locationBooth.text = item.location
            timeBooth.text = item.time
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_booth, parent, false)
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