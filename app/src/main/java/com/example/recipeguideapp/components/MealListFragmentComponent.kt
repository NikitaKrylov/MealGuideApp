package com.example.recipeguideapp.components

import MealListAdapter
import com.example.recipeguideapp.databinding.FragmentListMealBinding
import com.example.recipeguideapp.ui.view.MealItemDiffCalculator

class MealListFragmentComponent(binding: FragmentListMealBinding, onCardAction: (id: Int) -> Unit, onCheckBoxAction: (id: Int, isChecked: Boolean) -> Unit) {
    val adapter = MealListAdapter(MealItemDiffCalculator(), onCardAction, onCheckBoxAction)
}