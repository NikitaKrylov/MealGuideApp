package com.example.recipeguideapp.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recipeguideapp.databinding.FragmentMealDetailBinding

class MealDetailFragment : Fragment() {
    private lateinit var binding: FragmentMealDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMealDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

}