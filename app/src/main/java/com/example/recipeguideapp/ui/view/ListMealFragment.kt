package com.example.recipeguideapp.ui.view

import MealListAdapter
import android.os.Bundle
import android.os.RecoverySystem
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeguideapp.App
import com.example.recipeguideapp.MealViewModel
import com.example.recipeguideapp.R
import com.example.recipeguideapp.components.MealListFragmentComponent
import com.example.recipeguideapp.components.ViewModelFactory
import com.example.recipeguideapp.data.models.MealData
import com.example.recipeguideapp.databinding.FragmentListMealBinding


class ListMealFragment : Fragment(R.layout.fragment_list_meal){
    private val applicationComponent
        get() = App.get(requireContext()).appComponent
    private lateinit var binding: FragmentListMealBinding
    private lateinit var fragmentComponent: MealListFragmentComponent
    private val viewModel: MealViewModel by viewModels { applicationComponent.viewModelFactory }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListMealBinding.inflate(inflater, container, false)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentComponent = MealListFragmentComponent(binding)
//
        val rec = view.findViewById<RecyclerView>(R.id.mealRecyclerView)
        rec.layoutManager = LinearLayoutManager(context)
        rec.adapter = fragmentComponent.adapter
        viewModel.meals.observe(viewLifecycleOwner){ meals ->
            fragmentComponent.adapter.submitList(meals.meals.map { it.transformToMealData() })}


        viewModel.getMealsNyName("Cake")


    }
}