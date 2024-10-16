package com.example.pokedexmarioban2dam.models

import com.google.gson.annotations.SerializedName

data class PokemonSpeciesModel(
    @SerializedName("flavor_text_entries")
    val flavorTextEntry: List<FlavorTextEntry>
)

data class FlavorTextEntry(
    @SerializedName("flavor_text")
    val flavorText: String,
    val language: Language,
    val version: Version
)

data class Language(
    val name: String,
    val url: String
)

data class Version(
    val name: String,
    val url: String
)