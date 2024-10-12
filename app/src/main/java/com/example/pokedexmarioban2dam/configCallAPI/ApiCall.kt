package com.example.pokedexmarioban2dam.configCallAPI

import com.example.pokedexmarioban2dam.service.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    // THE 1 GEN Pokemon
    private const val BASE_URL = "https://pokeapi.co/api/v2/pokemon/?offset=0&limit=121";

    val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}

object ApiCall {
    val apiService: ApiService by lazy {
        RetrofitClient.retrofit.create(ApiService::class.java)
    }
}