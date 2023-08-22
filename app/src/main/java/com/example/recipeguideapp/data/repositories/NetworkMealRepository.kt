package com.example.recipeguideapp.data.repositories

import com.example.recipeguideapp.data.datasource.themealdb.models.Areas
import com.example.recipeguideapp.data.datasource.themealdb.models.Categories
import com.example.recipeguideapp.data.datasource.themealdb.models.Meals
import com.example.recipeguideapp.data.datasource.themealdb.models.MealsDetail
import com.example.recipeguideapp.data.models.CategoryData
import com.example.recipeguideapp.data.models.MealData
import retrofit2.Response

interface NetworkMealRepository {
    suspend fun getMealsByName(name: String): Response<Meals>
    suspend fun getAllCategories(): Response<Categories>
    suspend fun getAllAreas(): Response<Areas>
    suspend fun getMealById(id: Int): Response<MealsDetail>
    suspend fun filterByCategoryName(categoryName: String): Response<Meals>
}