package com.example.recipeguideapp.data.models


data class MealData(
    val id: Int,
    val name: String,
    val category: CategoryData,
    val instructions: String,
    val thumb: String? = null,
    val strTags: String? = null,
    val youtubeUrl: String? = null

    )
