package com.example.pokedexmarioban2dam

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedexmarioban2dam.models.PokemonDTOModel
import com.example.pokedexmarioban2dam.models.PokemonModel
import com.example.pokedexmarioban2dam.service.PokemonService

class FirstFragmentViewModel : ViewModel() {

    private val _pokemonList = MutableLiveData<List<PokemonModel>>()
    private val pokemonService = PokemonService()

    val pokemonList: LiveData<List<PokemonModel>> get() = _pokemonList

    // LiveData to expose only the DTO data
    val pokemonDTOList = MediatorLiveData<List<PokemonDTOModel>>().apply {
        addSource(_pokemonList) { list ->
            value = list.map { pokemonModel ->
                PokemonDTOModel(
                    pokemonModel.id,
                    pokemonModel.name,
                    pokemonModel.sprites
                )
            }
        }
    }

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
            // Handle error
        })
    }
}
}