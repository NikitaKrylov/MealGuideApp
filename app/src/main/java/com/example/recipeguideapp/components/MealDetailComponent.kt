package com.example.recipeguideapp.components

import com.example.recipeguideapp.ui.fragment.MealDetailFragment
import com.example.recipeguideapp.ui.view.adapter.IngredientsAdapter

class MealDetailComponent(val fragment: MealDetailFragment) {
    val ingredientsAdapter = IngredientsAdapter()
}