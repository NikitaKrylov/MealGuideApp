package com.example.recipeguideapp.ui.view

import MealListAdapter
import android.os.Bundle
import android.os.RecoverySystem
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageButton
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.recipeguideapp.App
import com.example.recipeguideapp.MealViewModel
import com.example.recipeguideapp.R
import com.example.recipeguideapp.components.MealListFragmentComponent
import com.example.recipeguideapp.components.ViewModelFactory
import com.example.recipeguideapp.data.models.MealData
import com.example.recipeguideapp.databinding.FragmentListMealBinding
import androidx.appcompat.widget.SearchView.OnQueryTextListener


class ListMealFragment : Fragment(R.layout.fragment_list_meal){
    private val applicationComponent
        get() = App.get(requireContext()).appComponent
    private lateinit var binding: FragmentListMealBinding
    private lateinit var fragmentComponent: MealListFragmentComponent
    private lateinit var mealListController: MealListController
    private val viewModel: MealViewModel by viewModels { applicationComponent.viewModelFactory }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListMealBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentComponent = MealListFragmentComponent(binding)
        mealListController = MealListController(binding, viewModel, fragmentComponent.adapter, viewLifecycleOwner)

        mealListController.setUpMeals()


        binding.searchInput.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean = false
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { viewModel.getMealsNyName(it) }
                return false
            }


        } )

        binding.filterButton.setOnClickListener {
            FilterBottomSheetFragment().show(childFragmentManager, null)
        }


    }
}