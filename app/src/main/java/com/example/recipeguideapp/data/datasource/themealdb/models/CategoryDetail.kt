package com.example.recipeguideapp.data.datasource.themealdb.models

import com.google.gson.annotations.SerializedName

data class CategoryDetail(
    @SerializedName("idCategory")
    val id: String,
    @SerializedName("strCategory")
    val name: String,
    @SerializedName("strCategoryThumb")
    val thumbUrl: String,
    @SerializedName("strCategoryDescription")
    val description: String
)
