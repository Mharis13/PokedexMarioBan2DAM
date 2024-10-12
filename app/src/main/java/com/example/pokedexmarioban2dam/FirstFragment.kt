package com.example.pokedexmarioban2dam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.pokedexmarioban2dam.databinding.FragmentFirstBinding
import com.example.pokedexmarioban2dam.models.PokemonModel

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FirstFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = PokemonDetailsListView(requireContext(), ArrayList())
        binding.PokemonsList.adapter = adapter

        viewModel.pokemonList.observe(viewLifecycleOwner, Observer { list ->
            adapter.dataSource.clear()
            adapter.dataSource.addAll(list)
            adapter.notifyDataSetChanged()
        })

        if (viewModel.pokemonList.value == null) {
            viewModel.fetchPokemonList()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}