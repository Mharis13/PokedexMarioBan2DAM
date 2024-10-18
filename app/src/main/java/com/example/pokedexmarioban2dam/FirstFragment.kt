package com.example.pokedexmarioban2dam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.pokedexmarioban2dam.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private lateinit var progressBar: ProgressBar

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
        progressBar = binding.progressBar2

        val adapter = PokemonDetailsListView(requireContext(), ArrayList())
        binding.PokemonsList.adapter = adapter

        var filterList = arguments?.getStringArrayList("filterList")
        if (filterList == null) {
            filterList = arrayListOf("all")
        }

        // For avoid the connect more times to the API when the app is open
        viewModel.pokemonList.observe(viewLifecycleOwner) { list ->
            if (list.isNotEmpty()) {
                progressBar.visibility = View.GONE
                binding.PokemonsList.visibility = View.VISIBLE
                binding.textView.visibility = View.VISIBLE

                filterPokemonList(filterList, adapter)
            } else {
                progressBar.visibility = View.VISIBLE
                binding.PokemonsList.visibility = View.GONE
                binding.textView.visibility = View.GONE
            }
        }

        if (viewModel.pokemonList.value == null) {
            viewModel.fetchPokemonList()
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // Easy filter function. filter by many types
    private fun filterPokemonList(types : List<String>, adapter: PokemonDetailsListView) {
        val filteredList = if (types.contains("all")  ) {
            viewModel.pokemonList.value ?: emptyList()
        } else{
            viewModel.pokemonList.value?.filter { pokemon ->
                pokemon.types.any {type -> types.contains(type.type.name) }
            } ?: emptyList()
        }
        adapter.dataSource.clear()
        adapter.dataSource.addAll(filteredList)
        adapter.notifyDataSetChanged()
    }
}