package com.example.recipeguideapp.data.datasource.themealdb.models

import com.google.gson.annotations.SerializedName

data class MealDetail(
    @SerializedName("idMeal")
    val id: Int,
    @SerializedName("strMeal")
    val name: String,
    @SerializedName("strCategory")
    val category: String,
    @SerializedName("strInstructions")
    val instructions: String,
    @SerializedName("strMealThumb")
    val thumbUrl: String,
    @SerializedName("tags")
    val tags: String?,
    @SerializedName("strYoutube")
    val youtubeUrl: String?

)