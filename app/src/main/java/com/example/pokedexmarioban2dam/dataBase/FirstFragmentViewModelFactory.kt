package com.example.pokedexmarioban2dam

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokedexmarioban2dam.repository.PokemonRepository

class FirstFragmentViewModelFactory(private val repository: PokemonRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FirstFragmentViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FirstFragmentViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}