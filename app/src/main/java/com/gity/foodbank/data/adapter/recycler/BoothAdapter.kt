package com.gity.foodbank.data.adapter.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gity.foodbank.R
import com.gity.foodbank.data.model.DataItem

class BoothAdapter(private val booths: List<DataItem>) :
    RecyclerView.Adapter<BoothAdapter.BoothViewHolder>() {

    class BoothViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val boothImage: ImageView = itemView.findViewById(R.id.iv_booth_image)
        val boothTitle: TextView = itemView.findViewById(R.id.tv_booth_title)
        val boothFoods: TextView = itemView.findViewById(R.id.tv_booth_foods)
        val boothAddress: TextView = itemView.findViewById(R.id.tv_booth_location)
        val boothTime: TextView = itemView.findViewById(R.id.tv_booth_time)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoothViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_booth, parent, false)
        return BoothViewHolder(view)
    }

    override fun getItemCount() = booths.size

    override fun onBindViewHolder(holder: BoothViewHolder, position: Int) {
        val booth = booths[position]
        Glide.with(holder.itemView.context)
            .load(booth.image)
            .into(holder.boothImage)

        holder.boothTitle.text = booth.name
        holder.boothFoods.text = booth.foodTotal.toString()
        holder.boothAddress.text = booth.address
        holder.boothTime.text = booth.timeOpen
    }

}