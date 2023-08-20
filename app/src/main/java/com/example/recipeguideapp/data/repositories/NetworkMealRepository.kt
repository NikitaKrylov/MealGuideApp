package com.example.recipeguideapp.data.repositories

import com.example.recipeguideapp.data.datasource.themealdb.models.Meals
import com.example.recipeguideapp.data.models.CategoryData
import com.example.recipeguideapp.data.models.MealData
import retrofit2.Response

interface NetworkMealRepository {
    suspend fun getMealsByName(name: String): Response<Meals>
    suspend fun getAllCategories(): List<CategoryData>
    suspend fun getMealById(id: Int): MealData?
    suspend fun filterByCategoryName(categoryName: String): List<MealData>
}