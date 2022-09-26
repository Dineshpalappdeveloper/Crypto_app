package com.example.cryptoapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object apiUtilities {
    fun getInstance() : Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://coinmarketcap.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}