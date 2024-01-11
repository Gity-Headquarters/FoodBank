package com.gity.foodbank.data.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gity.foodbank.data.model.DataItem
import com.gity.foodbank.databinding.ListItemBoothBinding

class ListItemBoothAdapter : RecyclerView.Adapter<ListItemBoothAdapter.BoothViewHolder>() {

    private var listBooth: List<DataItem> = emptyList()

    interface ItemClickListener {
        fun onItemClick(position: Int)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newList: List<DataItem>) {
        listBooth = newList
        notifyDataSetChanged()
    }

    class BoothViewHolder(private val binding: ListItemBoothBinding) :
        RecyclerView.ViewHolder(binding.root) {

//        private val imageBooth: ImageView = itemView.findViewById(R.id.iv_booth_image)
//        private val titleBooth: TextView = itemView.findViewById(R.id.tv_booth_title)
//        private val foodsBooth: TextView = itemView.findViewById(R.id.tv_booth_foods)
//        private val locationBooth: TextView = itemView.findViewById(R.id.tv_booth_location)
//        private val timeBooth: TextView = itemView.findViewById(R.id.tv_booth_time)

        fun bind(context: Context, itemBooth: DataItem) {

            binding.apply {
                tvBoothTitle.text = itemBooth.name
                tvBoothFoods.text = itemBooth.foodTotal.toString()
                tvBoothLocation.text = itemBooth.address
                tvBoothTime.text = itemBooth.timeOpen
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoothViewHolder {
        val view = ListItemBoothBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return BoothViewHolder(view)
    }

    override fun getItemCount() = listBooth.size

    override fun onBindViewHolder(holder: BoothViewHolder, position: Int) {
        holder.bind(holder.itemView.context, listBooth[position])
    }

}