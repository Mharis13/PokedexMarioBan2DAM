package com.example.pokedexmarioban2dam.service

import com.example.pokedexmarioban2dam.models.PokemonModel

// "Repository" class to handle data operations
data class PokemonResponse (
     val results: List<PokemonModel>
 )