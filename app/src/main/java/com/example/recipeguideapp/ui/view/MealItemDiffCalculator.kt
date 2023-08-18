package com.example.recipeguideapp.ui.view

import androidx.recyclerview.widget.DiffUtil
import com.example.recipeguideapp.data.models.MealData

class MealItemDiffCalculator : DiffUtil.ItemCallback<MealData>() {
    override fun areItemsTheSame(oldItem: MealData, newItem: MealData): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: MealData, newItem: MealData): Boolean = oldItem == newItem
}