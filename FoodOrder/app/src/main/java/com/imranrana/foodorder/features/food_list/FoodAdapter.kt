package com.imranrana.foodorder.features.food_list

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.imranrana.foodorder.R
import com.imranrana.foodorder.core.ItemClickListener
import com.imranrana.foodorder.model.Food

class FoodAdapter(private val list: MutableList<Food>, private val itemClickListener: ItemClickListener): RecyclerView.Adapter<FoodViewHolder>() {
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_food,parent,false)
        return FoodViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = list[position]

        Glide.with(context)
            .load(food.imageUrl)
            .centerCrop()
            .into(holder.foodImage)

        holder.foodName.text = food.name
        holder.foodOriginalPrice.text = food.originalPrice
        if (food.isFavorite){
            holder.isFavorite.visibility = View.VISIBLE
        }else{
            holder.isNotFavorite.visibility = View.VISIBLE
        }

        holder.discountPercentage.text = food.discountRatio + "% Off"
        holder.discountPrice.text = food.discountPrice
        holder.discountPrice.paintFlags= Paint.STRIKE_THRU_TEXT_FLAG

        holder.foodImage.setOnClickListener{
            clickListener(position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    private fun clickListener(position: Int){
        itemClickListener.itemClick(position)
    }

}