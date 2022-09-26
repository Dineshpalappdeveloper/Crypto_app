package com.example.cryptoapp.api

import com.example.cryptoapp.model.marketmodel
import retrofit2.Response
import retrofit2.http.GET

interface apiInterface {
    @GET("data-api/v3/cryptocurrency/listing?start=1&limit=500")
   suspend fun getMarketData(): Response<marketmodel>
}