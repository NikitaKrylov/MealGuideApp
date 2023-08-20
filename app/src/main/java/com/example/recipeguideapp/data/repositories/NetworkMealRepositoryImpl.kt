package com.example.recipeguideapp.data.repositories

import com.example.recipeguideapp.data.datasource.themealdb.ThemealdbApi
import com.example.recipeguideapp.data.datasource.themealdb.models.Meals
import com.example.recipeguideapp.data.models.CategoryData
import com.example.recipeguideapp.data.models.MealData
import retrofit2.Response

class NetworkMealRepositoryImpl(private val dataSource: ThemealdbApi): NetworkMealRepository {

    override suspend fun getMealsByName(name: String): Response<Meals> = dataSource.getRecipesByMealName(name)


    override suspend fun getAllCategories(): List<CategoryData> {
        TODO("Not yet implemented")
    }

    override suspend fun getMealById(id: Int): MealData? {
        TODO("Not yet implemented")
    }

    override suspend fun filterByCategoryName(categoryName: String): List<MealData> {
        TODO("Not yet implemented")
    }


}