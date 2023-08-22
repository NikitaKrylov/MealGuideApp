package com.example.recipeguideapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.recipeguideapp.App
import com.example.recipeguideapp.MealViewModel
import com.example.recipeguideapp.components.MealDetailFragmentController
import com.example.recipeguideapp.data.datasource.themealdb.models.MealDetail
import com.example.recipeguideapp.databinding.FragmentMealDetailBinding

class MealDetailFragment : Fragment() {
    private val applicationComponent
        get() = App.get(requireContext()).appComponent
    private lateinit var binding: FragmentMealDetailBinding
    private val args: MealDetailFragmentArgs by navArgs()
    private lateinit var controller: MealDetailFragmentController
    private val viewModel: MealViewModel by viewModels { applicationComponent.viewModelFactory }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMealDetailBinding.inflate(inflater, container, false)
        controller = MealDetailFragmentController(requireContext(), binding, viewLifecycleOwner, viewModel)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadMealDetail(args.mealId)
        controller.setUp()
    }

}