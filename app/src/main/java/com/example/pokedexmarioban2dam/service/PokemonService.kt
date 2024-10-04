package com.example.pokedexmarioban2dam.service

import com.example.pokedexmarioban2dam.configCallAPI.ApiCall
import com.example.pokedexmarioban2dam.models.PokemonModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonService {

  fun getPokemon(id:String, onSuccess:(PokemonModel) -> Unit, onError:(Throwable) -> Unit) {
      val call = ApiCall.apiService.getPokemon(id)

      call.enqueue(object : Callback<PokemonModel> {
          override fun onResponse(call: Call<PokemonModel>, response: Response<PokemonModel>) {
              if (response.isSuccessful){
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
}