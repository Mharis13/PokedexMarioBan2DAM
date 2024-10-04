package com.example.pokedexmarioban2dam.service

import com.example.pokedexmarioban2dam.models.PokemonModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("{id}/")
    fun getPokemon(@Path("id") id: String): Call<PokemonModel>

}