package com.example.recipeguideapp.components

import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipeguideapp.MealViewModel
import com.example.recipeguideapp.data.State
import com.example.recipeguideapp.databinding.FragmentFilterBottomSheetBinding


class FilterBottomSheetController(
    private val viewModel: MealViewModel,
    private val binding: FragmentFilterBottomSheetBinding,
    private val component: FilterBottomSheetComponent,
    private val viewLifecycleOwner: LifecycleOwner
    ) {

    fun setUpFilters(){
        setUpCategoryFilter()
        setUpAreaFilter()
    }

    private fun setUpAreaFilter(){
        binding.areaRecyclerView.apply {
            layoutManager = GridLayoutManager(context, 2, GridLayoutManager.HORIZONTAL, false)
            adapter = component.areaAdapter
        }

        viewModel.loadAreasIfNotInCache()

        viewModel.categories.observe(viewLifecycleOwner) { state ->
            if (state.status == State.Companion.Status.SUCCESS && state.data?.meals != null){
                component.categoryAdapter.submitList(state.data.meals.map { it.name })
            }
        }
    }

    private fun setUpCategoryFilter(){
        binding.categoryRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = component.categoryAdapter
        }

        viewModel.loadCategoriesIfNotInCache()

        viewModel.areas.observe(viewLifecycleOwner) { state ->
            if (state.status == State.Companion.Status.SUCCESS && state.data?.values != null){
                component.areaAdapter.submitList(state.data.values.map { it.name })
            }
        }
    }

    private fun setUpFilterActions(){
        binding.applyFilterButton.setOnClickListener {

        }
        binding.resetFilterButton.setOnClickListener {

        }
    }
}