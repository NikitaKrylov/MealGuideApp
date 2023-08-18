package com.example.recipeguideapp.components

import androidx.lifecycle.ViewModelProvider
import com.example.recipeguideapp.MealViewModel
import com.example.recipeguideapp.data.RetrofitServiceFactory
import com.example.recipeguideapp.data.datasource.themealdb.ThemealdbApi
import com.example.recipeguideapp.data.repositories.MealRepository
import com.example.recipeguideapp.data.repositories.MealRepositoryImpl


class AppComponent{
    private val dataSource = RetrofitServiceFactory.getApi("http://themealdb.com/api/json/v1/1/", ThemealdbApi::class.java)
    private val mealRepository: MealRepository = MealRepositoryImpl(dataSource)

    val viewModelFactory = ViewModelFactory(mealRepository)
}