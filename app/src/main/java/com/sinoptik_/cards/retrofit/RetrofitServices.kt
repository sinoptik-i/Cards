package com.sinoptik_.cards.retrofit

import com.sinoptik_.cards.data.dto.FullCard
import retrofit2.http.GET
import retrofit2.http.Path


//https://lookup.binlist.net/45717360

interface RetrofitServices {
    @GET("/{bin}")
    suspend fun getCard(@Path("bin")  bin: String): FullCard
}