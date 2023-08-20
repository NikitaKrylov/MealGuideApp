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
import com.google.android.material.bottomappbar.BottomAppBar.MenuAlignmentMode
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException


class MealViewModel(private val repository: MealRepository) : ViewModel(){
    val meals = MutableLiveData<Response<Meals>>()

    fun getMealsNyName(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = try {
                repository.getMealsByName(name)
            }
            catch (e: IOException){
                return@launch
            }
            catch (e: HttpException){
                return@launch
            }
            meals.postValue(response)

        }
    }

}


