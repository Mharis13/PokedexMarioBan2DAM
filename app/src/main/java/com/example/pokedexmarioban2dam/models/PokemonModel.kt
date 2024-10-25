package com.example.pokedexmarioban2dam.models

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.annotations.SerializedName
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "pokemon_table")
@Parcelize
data class PokemonModel(
    @PrimaryKey
    var id: Double,
    var name: String,
    var types: List<Type>,
    var weight: Double,
    var stats: List<Stat>,
    var sprites: Sprites
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

class Converters {
    @TypeConverter
    fun fromTypeList(value: List<Type>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Type>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toTypeList(value: String): List<Type> {
        val gson = Gson()
        val type = object : TypeToken<List<Type>>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromStatList(value: List<Stat>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Stat>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toStatList(value: String): List<Stat> {
        val gson = Gson()
        val type = object : TypeToken<List<Stat>>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromSprites(value: Sprites): String {
        val gson = Gson()
        return gson.toJson(value)
    }

    @TypeConverter
    fun toSprites(value: String): Sprites {
        val gson = Gson()
        return gson.fromJson(value, Sprites::class.java)
    }
}