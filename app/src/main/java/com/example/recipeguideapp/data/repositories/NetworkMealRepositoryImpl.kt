package com.example.recipeguideapp.data.repositories

import com.example.recipeguideapp.data.datasource.themealdb.ThemealdbApi
import com.example.recipeguideapp.data.datasource.themealdb.models.Areas
import com.example.recipeguideapp.data.datasource.themealdb.models.Categories
import com.example.recipeguideapp.data.datasource.themealdb.models.Category
import com.example.recipeguideapp.data.datasource.themealdb.models.Meals
import com.example.recipeguideapp.data.datasource.themealdb.models.MealsDetail
import com.example.recipeguideapp.data.models.CategoryData
import com.example.recipeguideapp.data.models.MealData
import retrofit2.Response

class NetworkMealRepositoryImpl(private val dataSource: ThemealdbApi): NetworkMealRepository {

    override suspend fun getMealsByName(name: String): Response<Meals> = dataSource.getRecipesByMealName(name)
    override suspend fun getAllCategories(): Response<Categories>  = dataSource.getAllCategories()
    override suspend fun getAllAreas(): Response<Areas> = dataSource.getAllAreas()

    override suspend fun getMealById(id: Int): Response<MealsDetail> = dataSource.getMealDetailById(id)

    override suspend fun filterByCategoryName(categoryName: String): Response<Meals> = dataSource.filterByCategory(categoryName)


}