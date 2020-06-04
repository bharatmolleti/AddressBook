package com.molleti.adressbook.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private const val URL = "https://5ed876c0152c310016d85c06.mockapi.io"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: RetrofitInterface = getRetrofit().create(RetrofitInterface::class.java)
}