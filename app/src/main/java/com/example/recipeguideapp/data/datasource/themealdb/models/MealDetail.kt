package com.example.recipeguideapp.data.datasource.themealdb.models

import com.example.recipeguideapp.data.models.CategoryData
import com.example.recipeguideapp.data.models.MealData

data class MealDetail(
    val idMeal: Int,
    val strMeal: String,
    val strCategory: String,
    val strInstructions: String,
    val strMealThumb: String,
    val strTags: String,
    val strYoutube: String?

){
    fun transformToMealData() = MealData(
        idMeal,
        strMeal,
        CategoryData(strCategory),
        strInstructions,
        strMealThumb,
        strTags,
        strYoutube
    )
}