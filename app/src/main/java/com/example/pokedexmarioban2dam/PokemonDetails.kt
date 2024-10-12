package com.example.pokedexmarioban2dam

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.pokedexmarioban2dam.databinding.PokemonDetailsBinding
import com.example.pokedexmarioban2dam.models.PokemonModel
import com.squareup.picasso.Picasso
import java.util.Locale

class PokemonDetails : Fragment() {
    private var _binding: PokemonDetailsBinding? = null
    private val binding get() = _binding!!
    lateinit private var shinyButton: ImageButton
    var count = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = PokemonDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pokemon = arguments?.getParcelable<PokemonModel>("pokemon")

        if (pokemon != null) {
            binding.pokemonName.text = pokemon.name.uppercase(Locale.ROOT)
            binding.pokemonPokedexId.text = formatNumber001(pokemon.id.toInt())
            binding.pokemonType.text = pokemon.types[0].type.name.uppercase(Locale.ROOT)
            if (pokemon.types.size > 1){

            binding.pokemonType2.text = pokemon.types[1].type.name.uppercase(Locale.ROOT)
            }
            else{
                binding.pokemonType2.visibility = View.GONE
            }
            binding.pokemonWeight.text = pokemon.weight.toString()+"Kg"
            binding.pokemonHP.text = pokemon.stats[0].baseStat.toString() +"HP"
            Picasso.get().load(pokemon.sprites.frontDefault).into(binding.pokemonSprite)
            shinyButton = binding.shinyButton
            shinyButton.setImageResource(android.R.drawable.btn_star_big_on)
            shinyButton.setOnClickListener {
                if (shinyButton.isActivated) {
                    Picasso.get().load(pokemon.sprites.frontDefault).into(binding.pokemonSprite)
                    shinyButton.isActivated = false
                    shinyButton.setImageResource(android.R.drawable.btn_star_big_off)
                    shinyButton.imageTintList = null
                }
                else {
                    Picasso.get().load(pokemon.sprites.frontShiny).into(binding.pokemonSprite)
                    shinyButton.isActivated = true
                    shinyButton.setImageResource(android.R.drawable.btn_star_big_on)
                }
            }

        }

        binding.returnButton.setOnClickListener {
            requireActivity().onBackPressed()
        }

    }

    private fun formatNumber001(number: Int): String {
        return String.format("#%03d", number)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}