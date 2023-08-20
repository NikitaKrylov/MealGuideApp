package com.example.recipeguideapp.data.datasource.themealdb.models

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("strCategory")
    val name: String
)
