package com.example.recipeguideapp.components

import MealListAdapter
import com.example.recipeguideapp.databinding.FragmentListMealBinding
import com.example.recipeguideapp.ui.view.MealItemDiffCalculator

class MealListFragmentComponent(binding: FragmentListMealBinding) {
    val adapter = MealListAdapter(MealItemDiffCalculator())
}