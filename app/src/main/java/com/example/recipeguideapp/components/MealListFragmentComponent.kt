package com.example.recipeguideapp.components

import com.example.recipeguideapp.ui.view.adapter.MealListAdapter
import com.example.recipeguideapp.databinding.FragmentListMealBinding
import com.example.recipeguideapp.ui.view.adapter.MealItemDiffCalculator

class MealListFragmentComponent(binding: FragmentListMealBinding, onCardAction: (id: Int) -> Unit, onCheckBoxAction: (id: Int, isChecked: Boolean) -> Unit) {
    val adapter = MealListAdapter(MealItemDiffCalculator(), onCardAction, onCheckBoxAction)
}