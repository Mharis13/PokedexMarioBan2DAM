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
import com.example.pokedexmarioban2dam.service.PokemonService
import com.squareup.picasso.Picasso
import java.util.Locale

class PokemonDetails : Fragment() {
    private var _binding: PokemonDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var shinyButton: ImageButton


    private fun setPokemonSprite(): Map<String, Int> {
        val normalSprite = R.drawable.normal_icon_swsh
        val fireSprite = R.drawable.fire_icon_swsh
        val waterSprite = R.drawable.water_icon_swsh
        val electricSprite = R.drawable.electric_icon_swsh
        val grassSprite = R.drawable.grass_icon_swsh
        val iceSprite = R.drawable.ice_icon_swsh
        val fightingSprite = R.drawable.fighting_icon_swsh
        val poisonSprite = R.drawable.poison_icon_swsh
        val groundSprite = R.drawable.ground_icon_swsh
        val flyingSprite = R.drawable.flying_icon_swsh
        val psychicSprite = R.drawable.psychic_icon_swsh
        val bugSprite = R.drawable.bug_icon_swsh
        val ghostSprite = R.drawable.ghost_icon_swsh
        val dragonSprite = R.drawable.dragon_icon_swsh
        val rockSprite = R.drawable.rock_icon_swsh
        val darkSprite = R.drawable.dark_icon_swsh
        val steelSprite = R.drawable.steel_icon_swsh
        val fairySprite = R.drawable.fairy_icon_swsh

        val typesMap = mapOf(
            "normal" to normalSprite,
            "fire" to fireSprite,
            "water" to waterSprite,
            "electric" to electricSprite,
            "grass" to grassSprite,
            "ice" to iceSprite,
            "fighting" to fightingSprite,
            "poison" to poisonSprite,
            "ground" to groundSprite,
            "flying" to flyingSprite,
            "psychic" to psychicSprite,
            "bug" to bugSprite,
            "rock" to rockSprite,
            "ghost" to ghostSprite,
            "dragon" to dragonSprite,
            "dark" to darkSprite,
            "steel" to steelSprite,
            "fairy" to fairySprite

        )
        return typesMap

    }

    val typesMap = setPokemonSprite()
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
            val onSuccess: (String) -> Unit = { description ->
                binding.pokemonInformation.text = description
            }

            val onError: (Throwable) -> Unit = { error ->
                // Maneja el error, por ejemplo, mostrando un mensaje de error
                binding.pokemonInformation.text = "Error al cargar la descripción del Pokémon"

            }



            typesMap[pokemon.types[0].type.name]?.let {
                Picasso.get().load(it).into(binding.pokemonType)
            }


            if (pokemon.types.size > 1) {
                binding.pokemonType2.visibility = View.VISIBLE
                typesMap[pokemon.types[1].type.name]?.let {
                    Picasso.get().load(it).into(binding.pokemonType2)
                }
            } else {
                binding.pokemonType2.visibility = View.GONE
            }

            binding.pokemonWeight.text = "${pokemon.weight/10}Kg"
            binding.pokemonHP.text = "${pokemon.stats[0].baseStat}HP"
            Picasso.get().load(pokemon.sprites.frontDefault).into(binding.pokemonSprite)
            shinyButton = binding.shinyButton
            shinyButton.setImageResource(android.R.drawable.btn_star_big_off)
            shinyButton.setOnClickListener {
                if (shinyButton.isActivated) {
                    Picasso.get().load(pokemon.sprites.frontDefault).into(binding.pokemonSprite)
                    shinyButton.isActivated = false
                    shinyButton.setImageResource(android.R.drawable.btn_star_big_off)
                    shinyButton.imageTintList = null
                } else {
                    Picasso.get().load(pokemon.sprites.frontShiny).into(binding.pokemonSprite)
                    shinyButton.isActivated = true
                    shinyButton.setImageResource(android.R.drawable.btn_star_big_on)
                }
            }
            PokemonService().getPokemonSpecies(pokemon.id.toInt().toString().trim(),
                onSuccess, onError)
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