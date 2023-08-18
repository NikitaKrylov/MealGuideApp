package com.example.recipeguideapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeguideapp.data.datasource.themealdb.models.Category
import com.example.recipeguideapp.data.datasource.themealdb.models.Meal
import com.example.recipeguideapp.data.datasource.themealdb.models.MealDetail
import com.example.recipeguideapp.data.datasource.themealdb.models.Meals
import com.example.recipeguideapp.data.models.CategoryData
import com.example.recipeguideapp.data.models.MealData
import com.example.recipeguideapp.data.repositories.MealRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MealViewModel(private val repository: MealRepository) : ViewModel(){
    val meals = MutableLiveData<Meals>()

    fun getMealsNyName(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getMealsByName(name)
            if (response.isSuccessful && response.body() != null){
                meals.postValue(response.body())
            }
        }
    }

}


