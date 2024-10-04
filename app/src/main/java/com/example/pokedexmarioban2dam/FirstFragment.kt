package com.example.pokedexmarioban2dam

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pokedexmarioban2dam.databinding.FragmentFirstBinding
import android.util.Log
import android.widget.ListView
import com.example.pokedexmarioban2dam.models.PokemonDTOModel
import com.example.pokedexmarioban2dam.service.PokemonService

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private val pokemonService = PokemonService()
    private val pokemonList = ArrayList<PokemonDTOModel>()
    private lateinit var listView: ListView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listView = binding.PokemonsList
        listView.adapter = adapter
                    pokemon.id,
                    pokemon.name,
                    pokemon.sprites
                )


                    Log.d("API", "Sprite:" + sprites.frontDefault)
                    Log.d("API", "Sprite:" + sprites.frontShiny)
                }

            }, { error ->
                Log.e("API", error.toString())
            })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @SuppressLint("DefaultLocale")
    private fun formatNumber001(number: Int): String {
        return String.format("#%03d", number)
    }
}