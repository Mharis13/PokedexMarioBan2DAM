package com.example.pokedexmarioban2dam

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.pokedexmarioban2dam.models.PokemonModel
import com.example.pokedexmarioban2dam.models.PokemonDTOModel
import androidx.navigation.Navigation

class PokemonDetailsListView(private val context: Context, val dataSource: ArrayList<PokemonModel>) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: inflater.inflate(R.layout.pokemon_details_list_view, parent, false)

        val pokemonModel = getItem(position) as PokemonModel
        val pokemonDTOModel = PokemonDTOModel(
            pokemonModel.id,
            pokemonModel.name,
            pokemonModel.sprites
        )

        val spriteImageView = view.findViewById<ImageView>(R.id.pokemonSprite)
        val nameTextView = view.findViewById<TextView>(R.id.pokemonName)
        val idTextView = view.findViewById<TextView>(R.id.pokemonId)

        nameTextView.text = pokemonDTOModel.name.uppercase()
        idTextView.text = formatNumber001(pokemonDTOModel.id.toInt())

        Picasso.get().load(pokemonDTOModel.sprites.frontDefault).into(spriteImageView)

        view.setOnClickListener {
            val navController = Navigation.findNavController(parent!!)
            val bundle = Bundle()
            bundle.putParcelable("pokemon", pokemonModel)
            navController.navigate(R.id.action_FirstFragment_to_PokemonDetailsFragment, bundle)
        }
        return view
    }

    private fun formatNumber001(number: Int): String {
        return String.format("#%03d", number)
    }
}