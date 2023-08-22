package com.example.recipeguideapp.ui.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.recipeguideapp.data.datasource.themealdb.models.Meal
import com.example.recipeguideapp.data.datasource.themealdb.models.MealDetail
import com.example.recipeguideapp.data.models.MealData

class MealItemDiffCalculator : DiffUtil.ItemCallback<Meal>() {
    override fun areItemsTheSame(oldItem: Meal, newItem: Meal): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Meal, newItem: Meal): Boolean = oldItem == newItem
}