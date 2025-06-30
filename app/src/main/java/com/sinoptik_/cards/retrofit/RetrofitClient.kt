package com.example.newsaggregator.retrofit


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//import retrofit2.converter.gson.GsonConverterFactory

//https://lookup.binlist.net/45717360


object RetrofitClient {
    private var retrofit: Retrofit? = null

    fun getClient(baseUrl: String): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
}