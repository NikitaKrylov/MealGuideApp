package com.example.recipeguideapp.data.datasource.themealdb.models

import com.google.gson.annotations.SerializedName

data class MealsDetail(
    @SerializedName("meals")
    val values: List<MealDetail>
)
