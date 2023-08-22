package com.example.recipeguideapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipeguideapp.App
import com.example.recipeguideapp.MealViewModel
import com.example.recipeguideapp.components.FilterBottomSheetComponent
import com.example.recipeguideapp.components.FilterBottomSheetController
import com.example.recipeguideapp.data.State
import com.example.recipeguideapp.databinding.FragmentFilterBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FilterBottomSheetFragment : BottomSheetDialogFragment() {
    private val applicationComponent
        get() = App.get(requireContext()).appComponent
    private lateinit var binding: FragmentFilterBottomSheetBinding
    private lateinit var controller: FilterBottomSheetController
    private val component = FilterBottomSheetComponent()
    private val viewModel: MealViewModel by viewModels { applicationComponent.viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFilterBottomSheetBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        controller = FilterBottomSheetController(viewModel, binding, component, viewLifecycleOwner)
        controller.setUpFilters()
    }

}