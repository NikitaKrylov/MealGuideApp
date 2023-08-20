package com.example.recipeguideapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeguideapp.data.State
import com.example.recipeguideapp.data.datasource.themealdb.models.Meals
import com.example.recipeguideapp.data.repositories.NetworkMealRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException


class MealViewModel(private val repository: NetworkMealRepository) : ViewModel(){
    val meals = MutableLiveData<State<Meals>>()

    fun loadMealsByName(name: String) {
        meals.postValue(State.loading())

        viewModelScope.launch(Dispatchers.IO) {
            val response = try {
                repository.getMealsByName(name)
            }
            catch (e: IOException){
                meals.postValue(State.error(e))
                return@launch
            }
            catch (e: HttpException){
                meals.postValue(State.error(e))
                return@launch
            }
            meals.postValue(State.success(response.body()))


        }
    }

}


