package com.example.recipeguideapp.ui.fragment

import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.recipeguideapp.App
import com.example.recipeguideapp.MealViewModel
import com.example.recipeguideapp.R
import com.example.recipeguideapp.components.MealListFragmentComponent
import com.example.recipeguideapp.databinding.FragmentListMealBinding
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.core.view.doOnPreDraw
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigatorExtras
import com.example.recipeguideapp.components.MealListController
import com.example.recipeguideapp.ui.MainActivity


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
        fragmentComponent = MealListFragmentComponent(this::showMealDetails, viewModel::likeMealCard)
        mealListController = MealListController(binding, viewModel, fragmentComponent, viewLifecycleOwner)
        (requireActivity() as MainActivity).setTitle("Search")
        mealListController.setUpMeals()

        binding.searchInput.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean = false
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { viewModel.loadMealsByName(it) }
                return false
            }


        } )

        binding.filterButton.setOnClickListener {
            FilterBottomSheetFragment().show(childFragmentManager, null)
        }

    }

    private fun showMealDetails(id: Int, sharedView: View){
        Navigation.findNavController(binding.root).navigate(
            ListMealFragmentDirections.actionListMealFragmentToMealDetailFragment(id),
        )
    }

}