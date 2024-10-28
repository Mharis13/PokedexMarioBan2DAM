package com.example.pokedexmarioban2dam.dataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pokedexmarioban2dam.models.PokemonModel

@Dao
interface PokemonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPokemon(pokemonList: List<PokemonModel>)

    @Query("SELECT * FROM pokemon_table")
    suspend fun getAllPokemon(): List<PokemonModel>


    @Query("SELECT COUNT(*) FROM pokemon_table")
    fun getCount(): Int
}