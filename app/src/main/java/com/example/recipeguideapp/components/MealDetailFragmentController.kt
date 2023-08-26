package com.example.recipeguideapp.components

import android.content.Context
import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipeguideapp.MealViewModel
import com.example.recipeguideapp.data.State
import com.example.recipeguideapp.data.datasource.themealdb.models.MealDetail
import com.example.recipeguideapp.databinding.FragmentMealDetailBinding
import com.squareup.picasso.Picasso
import com.example.recipeguideapp.data.State.Companion.Status
import com.example.recipeguideapp.data.datasource.themealdb.models.IngredientUseCaseData
import com.example.recipeguideapp.data.datasource.themealdb.models.MealsDetail
import com.example.recipeguideapp.ui.MainActivity
import com.example.recipeguideapp.ui.view.adapter.IngredientsAdapter

class MealDetailFragmentController(
    private val context: Context,
    private val binding: FragmentMealDetailBinding,
    private val lifecycleOwner: LifecycleOwner,
    private val viewModel: MealViewModel,
    private val fragmentComponent: MealDetailComponent
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
        binding.title.text = data.name
        binding.instructions.text = data.instructions
        binding.ingredientsRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.ingredientsRecyclerView.adapter = fragmentComponent.ingredientsAdapter

        if (!data.measures.isNullOrEmpty() || !data.ingredients.isNullOrEmpty()){
            fragmentComponent.ingredientsAdapter.submitList((data.ingredients!! zip data.measures!!).map { IngredientUseCaseData(it.first, it.second) })
        }
    }
    private fun showLoading(){


    }
    private fun showError(){

    }
}
