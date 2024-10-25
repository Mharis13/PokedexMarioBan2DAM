package com.example.pokedexmarioban2dam.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.pokedexmarioban2dam.models.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Database(entities = [PokemonModel::class], version = 1, exportSchema = false)
@TypeConverters(PokemonDatabase.Converters::class)
abstract class PokemonDatabase : RoomDatabase() {

    abstract fun pokemonDao(): PokemonDao

    companion object {
        @Volatile
        private var INSTANCE: PokemonDatabase? = null

        fun getDatabase(context: Context): PokemonDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PokemonDatabase::class.java,
                    "pokemon_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

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
}