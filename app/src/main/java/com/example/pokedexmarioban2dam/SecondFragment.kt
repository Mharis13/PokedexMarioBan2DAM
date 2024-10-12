package com.example.pokedexmarioban2dam

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.pokedexmarioban2dam.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
//        pokemonService.getPokemon("1", {pokemon ->
//            Log.d("API", "Pokedex:" + formatNumber001(pokemon.id.toInt()))
//            Log.d("API", "Name:"+pokemon.name)
//            Log.d("API","Type:"+pokemon.types[0].type.name)
//            if (pokemon.types.size > 1) {
//                Log.d("API","Type:"+pokemon.types[1].type.name)
//            }
//            Log.d("API","Weight" + pokemon.weight)
//            Log.d("API","HP:" + pokemon.stats[0].baseStat)
//            pokemon.sprites.let { sprites ->
//                Log.d("API","Sprite:" + sprites.frontDefault)
//                Log.d("API","Sprite:" + sprites.frontShiny)
//            }
//
//        }, { error ->
//            Log.e("API", error.toString())
//        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_PokemonDetailsFragment)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}