package com.example.recipeguideapp.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitServiceFactory {

    fun <Service>getApi(baseUrl: String, service: Class<Service>): Service = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(service)


}