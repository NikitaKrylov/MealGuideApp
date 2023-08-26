package com.example.recipeguideapp.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeguideapp.data.datasource.themealdb.models.IngredientUseCaseData
import com.example.recipeguideapp.databinding.MealIngredientItemBinding

class IngredientsAdapter : ListAdapter<IngredientUseCaseData, IngredientsAdapter.IngredientViewHolder>(diffCalculator) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder =
        IngredientViewHolder(MealIngredientItemBinding.inflate(LayoutInflater.from(parent.context)))

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        val diffCalculator = object : DiffUtil.ItemCallback<IngredientUseCaseData>(){
            override fun areItemsTheSame(oldItem: IngredientUseCaseData, newItem: IngredientUseCaseData): Boolean = oldItem == newItem
            override fun areContentsTheSame(oldItem: IngredientUseCaseData, newItem: IngredientUseCaseData): Boolean = oldItem == newItem
        }
    }

    inner class IngredientViewHolder(
        private val binding: MealIngredientItemBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: IngredientUseCaseData){
            binding.ingredient.text = data.ingredient
            binding.measure.text = data.measure
        }
    }
}