package com.example.pokedexmarioban2dam

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.pokedexmarioban2dam.models.PokemonDTOModel
import com.squareup.picasso.Picasso

class PokemonDetailsListView(private val context: Context, private val dataSource: ArrayList<PokemonDTOModel>) : BaseAdapter() {

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
        val view: View = convertView ?: inflater.inflate(R.layout.pokemon_details_list_view, parent
            , false)

        val pokemon = getItem(position) as PokemonDTOModel

        val spriteImageView = view.findViewById<ImageView>(R.id.pokemonSprite)
        val nameTextView = view.findViewById<TextView>(R.id.pokemonName)
        val idTextView = view.findViewById<TextView>(R.id.pokemonId)

        nameTextView.text = pokemon.name
        idTextView.text = formatNumber001(pokemon.id.toInt())

        Picasso.get().load(pokemon.sprites.frontDefault).into(spriteImageView)

        return view
    }

    private fun formatNumber001(number: Int): String {
        return String.format("#%03d", number)
    }
}