package com.example.recipeguideapp.data.datasource.themealdb

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
    suspend fun getMealDetailById(@Query("i") id: Int): Call<Meals>

    @GET("random.php")
    suspend fun getRandomRecipe(): Call<Meals>

    @GET("categories.php")
    suspend fun getAllCategoriesDetail(): Call<CategoriesDetail>

    @GET("list.php?c=list")
    suspend fun getAllCategories(): Call<Categories>

    @GET("filter.php")
    suspend fun filterByCategoryName(@Query("c") categoryName: String): Call<MealsDetail>
}