package com.example.recipeguideapp.ui.view

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeguideapp.App
import com.example.recipeguideapp.data.models.MealData
import com.example.recipeguideapp.databinding.MealItemBinding
import com.squareup.picasso.Picasso

class MealViewHolder(private val binding: MealItemBinding, private val context: Context) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: MealData){
        binding.cardItemTitle.text = data.name
        Picasso.with(context).load(data.thumb).into(binding.cardItemThumb)
    }
}