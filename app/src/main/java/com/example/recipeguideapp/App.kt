package com.example.recipeguideapp

import android.app.Application
import android.content.Context
import com.example.recipeguideapp.components.AppComponent

class App : Application() {
    val appComponent by lazy { AppComponent() }
    companion object{
        fun get(context: Context): App = context.applicationContext as App
    }
}