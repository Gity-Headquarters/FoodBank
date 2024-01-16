package com.gity.foodbank.data.adapter.recycler

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gity.foodbank.data.model.DataItem
import com.gity.foodbank.databinding.ListItemBoothBinding
import com.gity.foodbank.ui.activity.detail.DetailBoothActivity

class BoothAdapter : RecyclerView.Adapter<BoothAdapter.BoothViewHolder>() {

    private var listItemBooth: List<DataItem> = emptyList()

    fun setData(newList: List<DataItem>) {
        val diffCallback = BoothDiffUtilCallback(listItemBooth, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        listItemBooth = newList.sortedByDescending { it.createdAt }
        diffResult.dispatchUpdatesTo(this)
    }

    inner class BoothViewHolder(private val binding: ListItemBoothBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(context: Context, booth: DataItem) {

            binding.root.setOnClickListener {
                val intent = Intent(context, DetailBoothActivity::class.java)
                intent.putExtra("extra_id", booth.guid)
                context.startActivity(intent)
            }

            binding.apply {
                Glide.with(itemView.context)
                    .load(booth.image)
                    .into(ivBoothImage)
                tvBoothTitle.text = booth.name
                tvBoothFoods.text = booth.foodTotal.toString()
                tvBoothLocation.text = booth.address
                tvBoothTime.text = booth.timeOpen
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoothViewHolder {
        val view = ListItemBoothBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BoothViewHolder(view)
    }

    override fun getItemCount() = listItemBooth.size

    override fun onBindViewHolder(holder: BoothViewHolder, position: Int) {
        holder.bind(holder.itemView.context, listItemBooth[position])
    }

    class BoothDiffUtilCallback(
        private val oldList: List<DataItem>,
        private val newList: List<DataItem>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].guid == newList[newItemPosition].guid
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }

}