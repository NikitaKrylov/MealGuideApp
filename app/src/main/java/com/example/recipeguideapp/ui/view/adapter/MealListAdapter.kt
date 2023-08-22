package com.example.recipeguideapp.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.recipeguideapp.data.datasource.themealdb.models.Meal
import com.example.recipeguideapp.data.datasource.themealdb.models.MealDetail
import com.example.recipeguideapp.data.models.MealData
import com.example.recipeguideapp.databinding.MealItemBinding

class MealListAdapter(
    mealDiffCalculator: MealItemDiffCalculator,
    private val onCardAction: (id: Int) -> Unit,
    private val onCheckBoxAction: (id: Int, isChecked: Boolean) -> Unit
) : ListAdapter<Meal, MealViewHolder>(mealDiffCalculator) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        return MealViewHolder(MealItemBinding.inflate(LayoutInflater.from(parent.context)), parent.context, onCardAction, onCheckBoxAction)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}