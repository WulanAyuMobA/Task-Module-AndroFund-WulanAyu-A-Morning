package com.example.latihan.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.latihan.databinding.ItemFoodBinding
import com.example.latihan.model.Food
import com.example.latihan.utils.Extension.showImageInto

class FoodAdapter(val dataFood: (Food)->Unit):ListAdapter<Food,FoodAdapter.FoodViewHolder>(DIFF_CALLBACK) {

     inner class FoodViewHolder(private val binding: ItemFoodBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(food: Food){
            binding.tvNamam.text = food.name
            binding.tvHarga.text = food.harga
            binding.siGambar.showImageInto(itemView.context, food.gambar)
            itemView.setOnClickListener{
                dataFood.invoke(food)
            }
        }

    }

    companion object{
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Food>(){
            override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean =
                oldItem == newItem
            override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean =
                oldItem.id == newItem.id

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = ItemFoodBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return FoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}