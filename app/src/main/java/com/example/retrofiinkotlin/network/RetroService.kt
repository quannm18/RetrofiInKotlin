package com.example.retrofiinkotlin.network

import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {
    //B2 Khai báo
    @GET("character")
    suspend fun getDataFromApi(@Query("page") query: Int): RickAndMortyList

}