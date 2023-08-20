package com.example.recipeguideapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeguideapp.data.State
import com.example.recipeguideapp.data.datasource.themealdb.models.Areas
import com.example.recipeguideapp.data.datasource.themealdb.models.Categories
import com.example.recipeguideapp.data.datasource.themealdb.models.Meals
import com.example.recipeguideapp.data.repositories.NetworkMealRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


class MealViewModel(private val repository: NetworkMealRepository) : ViewModel(){
    val meals = MutableLiveData<State<Meals>>()
    val categories = MutableLiveData<State<Categories>>()
    val areas = MutableLiveData<State<Areas>>()

    fun loadMealsByName(name: String) {
        meals.postValue(State.loading())

        viewModelScope.launch(Dispatchers.IO) {
            val response = try {
                repository.getMealsByName(name)
            } catch (e: IOException) {
                meals.postValue(State.error(e))
                return@launch
            } catch (e: HttpException) {
                meals.postValue(State.error(e))
                return@launch
            }
            meals.postValue(State.success(response.body()))


        }
    }

    fun likeMealCard(id: Int, isChecked: Boolean){

    }

    fun loadCategoriesIfNotInCache(){

        viewModelScope.launch(Dispatchers.IO) {
            val response = try {
                repository.getAllCategories()
            } catch (e: IOException) {
                categories.postValue(State.error(e))
                return@launch
            } catch (e: HttpException) {
                categories.postValue(State.error(e))
                return@launch
            }
            if (response.body() != categories.value?.data){
                categories.postValue(State.success(response.body()))
            }
        }
    }

    fun loadAreasIfNotInCache(){

        viewModelScope.launch(Dispatchers.IO) {
            val response = try {
                repository.getAllAreas()
            } catch (e: IOException) {
                areas.postValue(State.error(e))
                return@launch
            } catch (e: HttpException) {
                areas.postValue(State.error(e))
                return@launch
            }
            if (response.body() != areas.value?.data){
                areas.postValue(State.success(response.body()))
            }
        }
    }

}


