package com.example.recipeguideapp.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatRadioButton
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeguideapp.data.datasource.themealdb.models.Category
import com.example.recipeguideapp.databinding.FilterItemBinding

class BottomSheetFilterAdapter(diffCalc: FilterItemDiffCalculator) : ListAdapter<String, BottomSheetFilterAdapter.BottomSheetFilterViewHolder>(diffCalc) {
    lateinit var checked: Array<Boolean>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottomSheetFilterViewHolder =
        BottomSheetFilterViewHolder(FilterItemBinding.inflate(LayoutInflater.from(parent.context)))

    override fun onBindViewHolder(holder: BottomSheetFilterViewHolder, position: Int) = holder.bind(getItem(position), this, position)

    override fun submitList(list: List<String>?) {
        super.submitList(list)
        list?.let { checked =  Array(it.size){false} }
    }

    inner class BottomSheetFilterViewHolder(private val binding: FilterItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: String, adapter: BottomSheetFilterAdapter, position: Int){
            binding.filterItemButton.apply {
                text = data
                isChecked = adapter.checked[position]
                setOnClickListener {
                    adapter.checked[position] = !adapter.checked[position]
                }
            }
        }
    }


}