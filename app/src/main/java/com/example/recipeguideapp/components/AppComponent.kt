package com.example.recipeguideapp.components

import com.example.recipeguideapp.data.RetrofitServiceFactory
import com.example.recipeguideapp.data.datasource.themealdb.ThemealdbApi
import com.example.recipeguideapp.data.repositories.NetworkMealRepository
import com.example.recipeguideapp.data.repositories.NetworkMealRepositoryImpl


class AppComponent{
    private val dataSource = RetrofitServiceFactory.getApi("http://themealdb.com/api/json/v1/1/", ThemealdbApi::class.java)
    private val mealRepository: NetworkMealRepository = NetworkMealRepositoryImpl(dataSource)

    val viewModelFactory = ViewModelFactory(mealRepository)
}