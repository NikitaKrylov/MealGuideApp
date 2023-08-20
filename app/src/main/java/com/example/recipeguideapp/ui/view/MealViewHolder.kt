package com.example.recipeguideapp.ui.view

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeguideapp.App
import com.example.recipeguideapp.data.models.MealData
import com.example.recipeguideapp.databinding.MealItemBinding
import com.squareup.picasso.Picasso

class MealViewHolder(
    private val binding: MealItemBinding,
    private val context: Context,
    private val onCardAction: (id: Int) -> Unit,
    private val onCheckBoxAction: (id: Int, isChecked: Boolean) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: MealData){
        binding.cardItemTitle.text = data.name
        binding.cardView.setOnClickListener {
            onCardAction(data.id)
        }
        binding.cardCheckBox.setOnCheckedChangeListener { _, isChecked ->
            onCheckBoxAction(data.id, isChecked)
        }
        Picasso.with(context).load(data.thumb).into(binding.cardItemThumb)
    }
}