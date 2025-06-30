package com.sinoptik_.cards.retrofit

import com.example.newsaggregator.retrofit.RetrofitClient


//https://lookup.binlist.net/45717360


object Common {
    private val BASE_URL = "https://lookup.binlist.net"
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}