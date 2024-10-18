package com.example.pokedexmarioban2dam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.navigation.Navigation
import com.example.pokedexmarioban2dam.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private lateinit var pokemonFireTypeButton: ImageButton
    private lateinit var pokemonNormalTypeButton: ImageButton
    private lateinit var pokemonIceTypeButton: ImageButton
    private lateinit var pokemonWaterTypeButton: ImageButton
    private lateinit var pokemonGrassTypeButton: ImageButton
    private lateinit var pokemonFlyingTypeButton: ImageButton
    private lateinit var pokemonDarkTypeButton: ImageButton
    private lateinit var pokemonSteelTypeButton: ImageButton
    private lateinit var pokemonFairyTypeButton: ImageButton
    private lateinit var pokemonBugTypeButton: ImageButton
    private lateinit var pokemonPsychicTypeButton: ImageButton
    private lateinit var pokemonFightingTypeButton: ImageButton
    private lateinit var pokemonRockTypeButton: ImageButton
    private lateinit var pokemonGroundTypeButton: ImageButton
    private lateinit var pokemonGhostTypeButton: ImageButton
    private lateinit var pokemonElectricTypeButton: ImageButton
    private lateinit var pokemonPoisonTypeButton: ImageButton
    private lateinit var pokemonDragonTypeButton: ImageButton
    private lateinit var applyFiltersButton: Button
    private lateinit var resetFiltersButton: ImageButton

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pokemonGrassTypeButton = binding.grassTypeButton
        pokemonDragonTypeButton = binding.dragonTypeButton
        pokemonBugTypeButton = binding.bugTypeButton
        pokemonIceTypeButton = binding.iceTypeButton
        pokemonDarkTypeButton = binding.darkTypeButton
        pokemonElectricTypeButton = binding.electricTypeButton
        pokemonFairyTypeButton = binding.fairyTypeButton
        pokemonFightingTypeButton = binding.fightingTypeButton
        pokemonFireTypeButton = binding.fireTypeButton
        pokemonFlyingTypeButton = binding.flying
        pokemonNormalTypeButton = binding.normalTypeButton
        pokemonWaterTypeButton = binding.waterTypeButton
        pokemonGroundTypeButton = binding.groundTypeButton
        pokemonGhostTypeButton = binding.ghostTypeButton
        pokemonPoisonTypeButton = binding.poisonTypeButton
        pokemonRockTypeButton = binding.rockTypeButton
        pokemonSteelTypeButton = binding.steelTypeButton
        pokemonPsychicTypeButton = binding.psychicTypeButton
        applyFiltersButton = binding.applyFilterButton
        resetFiltersButton = binding.resetFiltersButton

        val listTypesFilter: ArrayList<String> = arrayListOf("all")

        pokemonFireTypeButton.setOnClickListener {
            handleButtonClick(pokemonFireTypeButton, "fire", listTypesFilter)
        }
        pokemonWaterTypeButton.setOnClickListener {
            handleButtonClick(pokemonWaterTypeButton, "water", listTypesFilter)
        }
        pokemonGrassTypeButton.setOnClickListener {
            handleButtonClick(pokemonGrassTypeButton, "grass", listTypesFilter)
        }
        pokemonGhostTypeButton.setOnClickListener {
            handleButtonClick(pokemonGhostTypeButton, "ghost", listTypesFilter)
        }
        pokemonGroundTypeButton.setOnClickListener {
            handleButtonClick(pokemonGroundTypeButton, "ground", listTypesFilter)
        }
        pokemonFairyTypeButton.setOnClickListener {
            handleButtonClick(pokemonFairyTypeButton, "fairy", listTypesFilter)
        }
        pokemonFlyingTypeButton.setOnClickListener {
            handleButtonClick(pokemonFlyingTypeButton, "flying", listTypesFilter)
        }
        pokemonFightingTypeButton.setOnClickListener {
            handleButtonClick(pokemonFightingTypeButton, "fighting", listTypesFilter)
        }
        pokemonPoisonTypeButton.setOnClickListener {
            handleButtonClick(pokemonPoisonTypeButton, "poison", listTypesFilter)
        }
        pokemonPsychicTypeButton.setOnClickListener {
            handleButtonClick(pokemonPsychicTypeButton, "psychic", listTypesFilter)
        }
        pokemonElectricTypeButton.setOnClickListener {
            handleButtonClick(pokemonElectricTypeButton, "electric", listTypesFilter)
        }
        pokemonSteelTypeButton.setOnClickListener {
            handleButtonClick(pokemonSteelTypeButton, "steel", listTypesFilter)
        }
        pokemonIceTypeButton.setOnClickListener {
            handleButtonClick(pokemonIceTypeButton, "ice", listTypesFilter)
        }
        pokemonNormalTypeButton.setOnClickListener {
            handleButtonClick(pokemonNormalTypeButton, "normal", listTypesFilter)
        }
        pokemonDarkTypeButton.setOnClickListener {
            handleButtonClick(pokemonDarkTypeButton, "dark", listTypesFilter)
        }
        pokemonDragonTypeButton.setOnClickListener {
            handleButtonClick(pokemonDragonTypeButton, "dragon", listTypesFilter)
        }
        pokemonRockTypeButton.setOnClickListener {
            handleButtonClick(pokemonRockTypeButton, "rock", listTypesFilter)
        }
        pokemonBugTypeButton.setOnClickListener {
            handleButtonClick(pokemonBugTypeButton, "bug", listTypesFilter)

        }

        applyFiltersButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putStringArrayList("filterList", listTypesFilter)
            Navigation.findNavController(view).navigate(R.id.action_SecondFragment_to_FirstFragment, bundle)
        }

        resetFiltersButton.setOnClickListener {
            listTypesFilter.clear()
            listTypesFilter.add("all")
        }
    }

    private fun handleButtonClick(button: ImageButton, type: String, listTypesFilter: ArrayList<String>) {
        if (listTypesFilter.contains("all") && listTypesFilter.size == 1) {
            listTypesFilter.clear()
        }
        button.isActivated = !button.isActivated
        if (button.isActivated) {
            listTypesFilter.add(type)
            button.elevation = 8f
        } else {
            button.elevation = 0f
            listTypesFilter.remove(type)
            if (listTypesFilter.isEmpty()) {
                listTypesFilter.add("all")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}