package com.example.recipeguideapp.components

import android.content.Context
import android.view.View
import androidx.lifecycle.LifecycleOwner
import com.example.recipeguideapp.MealViewModel
import com.example.recipeguideapp.data.State
import com.example.recipeguideapp.data.datasource.themealdb.models.MealDetail
import com.example.recipeguideapp.databinding.FragmentMealDetailBinding
import com.squareup.picasso.Picasso
import com.example.recipeguideapp.data.State.Companion.Status
import com.example.recipeguideapp.data.datasource.themealdb.models.MealsDetail

class MealDetailFragmentController(
    private val context: Context,
    private val binding: FragmentMealDetailBinding,
    private val lifecycleOwner: LifecycleOwner,
    private val viewModel: MealViewModel
    ) {

    fun setUp(){
        viewModel.currentMealDetail.observe(lifecycleOwner){ provideResponse(it) }
    }

    private fun provideResponse(state: State<MealDetail>){
        when (state.status){
            Status.SUCCESS -> {
                if (state.data == null) showError()
                else showMealDetail(state.data)
            }
            Status.LOADING -> showLoading()
            Status.ERROR -> showError()
        }
    }
    private fun showMealDetail(data: MealDetail){
        Picasso.with(context).load(data.thumbUrl).into(binding.cardItemThumb)
    }
    private fun showLoading(){


    }
    private fun showError(){

    }
}
