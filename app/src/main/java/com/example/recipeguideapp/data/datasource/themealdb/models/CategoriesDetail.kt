package com.example.recipeguideapp.data.datasource.themealdb.models

import com.google.gson.annotations.SerializedName

data class CategoriesDetail(
    @SerializedName("categories")
    val values: List<CategoryDetail>
)
