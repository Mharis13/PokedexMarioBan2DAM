package com.example.pokedexmarioban2dam.repository

import com.example.pokedexmarioban2dam.dataBase.PokemonDao
import com.example.pokedexmarioban2dam.models.PokemonModel

class PokemonRepository(private val pokemonDao: PokemonDao) {
    suspend fun insertAllPokemon(pokemonList: List<PokemonModel>) {
        pokemonDao.insertAllPokemon(pokemonList)
    }

    suspend fun getAllPokemon(): List<PokemonModel> {
        return pokemonDao.getAllPokemon()
    }
}