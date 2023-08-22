package com.example.recipeguideapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recipeguideapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setDisplayShowTitleEnabled(false)
        }
    }
}