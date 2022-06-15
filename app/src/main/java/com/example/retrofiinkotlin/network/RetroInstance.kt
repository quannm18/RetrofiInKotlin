package com.example.retrofiinkotlin.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {
    //B1: Tạo ra 1 cái Instance
    companion object {
        var baseUrl = "https://rickandmortyapi.com/api/"

        fun getRetroInstance(): Retrofit{
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}