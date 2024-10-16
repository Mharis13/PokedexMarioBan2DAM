package com.example.pokedexmarioban2dam.models

import com.google.gson.annotations.SerializedName
import android.os.Parcelable
import kotlinx.parcelize.Parcelize // For transport the data between fragments

@Parcelize
data class PokemonModel(
    var id: Double,
    var name: String,
    var types: List<Type>,
    var weight: Double,
    var stats: List<Stat>,
    var sprites: Sprites,

) : Parcelable

@Parcelize
data class Stat(
    @SerializedName("base_stat")
    var baseStat: Int,
    var effort: Int,
    var stat: StatDetail
) : Parcelable

@Parcelize
data class StatDetail(
    var name: String,
    var url: String
) : Parcelable

@Parcelize
data class Type(
    var slot: Int,
    var type: TypeDetail
) : Parcelable


@Parcelize
data class TypeDetail(
    var name: String,
    var url: String
) : Parcelable

@Parcelize
data class Sprites(
    @SerializedName("front_default")
    var frontDefault: String?,
    @SerializedName("front_shiny")
    var frontShiny: String?
) : Parcelable