package com.example.pokedexmarioban2dam.service

import android.util.Log
import com.example.pokedexmarioban2dam.configCallAPI.ApiCall
import com.example.pokedexmarioban2dam.models.PokemonModel
import com.example.pokedexmarioban2dam.models.PokemonSpeciesModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonService {

    fun getPokemon(id: String, onSuccess: (PokemonModel) -> Unit, onError: (Throwable) -> Unit) {
        val call = ApiCall.apiService.getPokemon(id)

        call.enqueue(object : Callback<PokemonModel> {
            override fun onResponse(call: Call<PokemonModel>, response: Response<PokemonModel>) {
                if (response.isSuccessful) {
                    response.body()?.let(onSuccess)

                } else {
                    onError(Throwable("Error: ${response.code()}"))
                }
            }

            override fun onFailure(call: Call<PokemonModel>, t: Throwable) {
                onError(t)
            }
        })


    }
    fun getPokemonSpecies(
        id: String,
        onSuccess: (String) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        val call = ApiCall.apiService.getPokemonSpecies(id)

        call.enqueue(object : Callback<PokemonSpeciesModel> {
            override fun onResponse(
                call: Call<PokemonSpeciesModel>,
                response: Response<PokemonSpeciesModel>
            ) {
                if (response.isSuccessful) {
                    val species = response.body()
                    if (species != null) {
                        Log.d("API_RESPONSE", "Species data: $species")
                        val description = species.flavorTextEntry.firstOrNull {
                            it.language.name == "es" && it.version.name == "x"
                        }?.flavorText ?: "Descripción no disponible"
                        Log.d("API_RESPONSE", "Description found: $description")
                        onSuccess(description)
                    } else {
                        Log.d("API_ERROR", "Response body is null")
                        onError(Throwable("Response body is null"))
                    }
                } else {
                    Log.d("API_ERROR", "Error code: ${response.code()}")
                    onError(Throwable("Error: ${response.code()}"))
                }
            }

            override fun onFailure(call: Call<PokemonSpeciesModel>, t: Throwable) {
                Log.d("API_ERROR", "Request failed: ${t.message}")
                onError(t)
            }
        })
    }

}