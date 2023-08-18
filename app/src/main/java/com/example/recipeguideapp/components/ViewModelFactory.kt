package com.example.recipeguideapp.components

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.recipeguideapp.MealViewModel
import com.example.recipeguideapp.data.repositories.MealRepository

class ViewModelFactory(private val mealRepository: MealRepository) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = when (modelClass) {
        MealViewModel::class.java -> MealViewModel(mealRepository)
        else -> throw IllegalArgumentException("${modelClass.simpleName} cannot be provided.")
    } as T
}