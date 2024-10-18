package com.example.pokedexmarioban2dam

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedexmarioban2dam.models.PokemonModel
import com.example.pokedexmarioban2dam.service.PokemonService

class FirstFragmentViewModel : ViewModel() {

    private val _pokemonList = MutableLiveData<List<PokemonModel>>()
    private val pokemonService = PokemonService()

    val pokemonList: LiveData<List<PokemonModel>> get() = _pokemonList

    fun fetchPokemonList() {
    val currentList = mutableListOf<PokemonModel>()
    val totalPokemon = 151
    var fetchedCount = 0

    for (i in 1..totalPokemon) {
        pokemonService.getPokemon(i.toString(), { pokemon ->
            val pokemonModel = PokemonModel(
                pokemon.id,
                pokemon.name,
                pokemon.types,
                pokemon.weight,
                pokemon.stats,
                pokemon.sprites,
            )
            currentList.add(pokemonModel)
            fetchedCount++

            if (fetchedCount == totalPokemon) {
                currentList.sortBy { it.id }
                _pokemonList.postValue(currentList.toList())
            }
        }, { error ->
            print("Error: $error")
            // Handle error
        })
    }
}
}