package com.example.pokedexmarioban2dam.service

import com.example.pokedexmarioban2dam.models.PokemonModel
import com.example.pokedexmarioban2dam.models.PokemonSpeciesModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("pokemon/{id}/")
    fun getPokemon(@Path("id") id: String): Call<PokemonModel>

    @GET("pokemon-species/{id}/")
    fun getPokemonSpecies(@Path("id") id: String): Call<PokemonSpeciesModel>

}