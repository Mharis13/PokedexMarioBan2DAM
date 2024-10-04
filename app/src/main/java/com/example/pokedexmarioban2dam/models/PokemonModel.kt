package com.example.pokedexmarioban2dam.models

import com.google.gson.annotations.SerializedName

data class PokemonModel(
    var id: Double,
    var name: String,
    var types: List<Type>,
    var weight: Double,
    var stats: List<Stat>,
    var sprites: Sprites
)
data class Stat(
    @SerializedName("base_stat")
    var baseStat: Int,
    var effort: Int,
    var stat: StatDetail
)
data class StatDetail(
    var name: String,
    var url: String
)
data class Type(
    var slot: Int,
    var type: TypeDetail
)

data class TypeDetail(
    var name: String,
    var url: String
)
data class Sprites(
    @SerializedName("front_default")
    var frontDefault : String?,
    @SerializedName("front_shiny")
    var frontShiny : String?
)