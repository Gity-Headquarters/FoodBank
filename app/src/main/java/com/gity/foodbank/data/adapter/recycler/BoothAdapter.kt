package com.gity.foodbank.data.adapter.recycler

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gity.foodbank.R
import com.gity.foodbank.data.model.DataItem
import com.gity.foodbank.ui.activity.detail.DetailBoothActivity

class BoothAdapter(
    private val booths: List<DataItem>,
    private val itemClickListener: ItemClickListener
) :
    RecyclerView.Adapter<BoothAdapter.BoothViewHolder>() {

    interface ItemClickListener {
        fun onItemClick(position: Int)
    }

    class BoothViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private val boothImage: ImageView = itemView.findViewById(R.id.iv_booth_image)
        private val boothTitle: TextView = itemView.findViewById(R.id.tv_booth_title)
        private val boothFoods: TextView = itemView.findViewById(R.id.tv_booth_foods)
        private val boothAddress: TextView = itemView.findViewById(R.id.tv_booth_location)
        private val boothTime: TextView = itemView.findViewById(R.id.tv_booth_time)

        fun bind(context: Context, item: DataItem) {
            Glide.with(itemView.context)
                .load(item.image)
                .into(boothImage)
            boothTitle.text = item.name
            boothFoods.text = item.foodTotal.toString()
            boothAddress.text = item.address
            boothTime.text = item.timeOpen

            itemView.setOnClickListener {
                val intent = Intent(context, DetailBoothActivity::class.java)
                context.startActivity(intent)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoothViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_booth, parent, false)
        return BoothViewHolder(view)
    }

    override fun getItemCount() = booths.size

    override fun onBindViewHolder(holder: BoothViewHolder, position: Int) {
        val booth = booths[position]
        holder.bind(holder.itemView.context, booth)

        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(position)
        }
    }

}