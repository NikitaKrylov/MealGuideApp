package com.example.recipeguideapp.components

import android.view.View
import com.example.recipeguideapp.ui.view.adapter.MealListAdapter
import com.example.recipeguideapp.databinding.FragmentListMealBinding
import com.example.recipeguideapp.ui.fragment.ListMealFragment
import com.example.recipeguideapp.ui.view.adapter.MealItemDiffCalculator

class MealListFragmentComponent(onCardAction: (id: Int, sharedView: View) -> Unit, onCheckBoxAction: (id: Int, isChecked: Boolean) -> Unit) {
    val adapter = MealListAdapter(MealItemDiffCalculator(), onCardAction, onCheckBoxAction)
}