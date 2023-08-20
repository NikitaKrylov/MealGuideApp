package com.example.recipeguideapp.data.datasource.themealdb

import com.example.recipeguideapp.data.datasource.themealdb.models.Areas
import com.example.recipeguideapp.data.datasource.themealdb.models.Categories
import com.example.recipeguideapp.data.datasource.themealdb.models.CategoriesDetail
import com.example.recipeguideapp.data.datasource.themealdb.models.MealsDetail
import com.example.recipeguideapp.data.datasource.themealdb.models.Meals
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ThemealdbApi {
    @GET("search.php")
    suspend fun getRecipesByMealName(@Query("s") name: String): Response<Meals>

    @GET("lookup.php")
    suspend fun getMealDetailById(@Query("i") id: Int): Response<Meals>

    @GET("random.php")
    suspend fun getRandomRecipe(): Response<Meals>

    @GET("categories.php")
    suspend fun getAllCategoriesDetail(): Response<CategoriesDetail>

    @GET("list.php?c=list")
    suspend fun getAllCategories(): Response<Categories>

    @GET("list.php?a=list")
    suspend fun getAllAreas(): Response<Areas>

    @GET("filter.php")
    suspend fun filterByCategory(@Query("c") categoryName: String): Response<Meals>

    @GET("filter.php")
    suspend fun filterByArea(@Query("a") areaName: String): Response<Meals>
}