package com.example.listaanimale.adapters

import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.listaanimale.AnimalListFragmentDirections
import com.example.listaanimale.R
import com.example.listaanimale.models.AnimalModel
import com.example.listaanimale.models.EContinent
import com.example.listaanimale.models.EContinent.Companion.getColorFromContinent

class AnimalListAdapter(
    private val items: List<AnimalModel>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int) = items[position].continent.key
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            EContinent.EUROPE.key -> {
                val view = inflater.inflate(R.layout.item_animal_europe, parent, false)
                AnimalViewHolder(view)
            }

            EContinent.AFRICA.key -> {
                val view = inflater.inflate(R.layout.item_animal_africa, parent, false)
                AnimalViewHolder(view)
            }

            EContinent.ASIA.key -> {
                val view = inflater.inflate(R.layout.item_animal_asia, parent, false)
                AnimalViewHolder(view)
            }

            EContinent.NORTH_AMERICA.key -> {
                val view = inflater.inflate(R.layout.item_animal_north_america, parent, false)
                AnimalViewHolder(view)
            }

            EContinent.SOUTH_AMERICA.key -> {
                val view = inflater.inflate(R.layout.item_animal_south_america, parent, false)
                AnimalViewHolder(view)
            }

            EContinent.AUSTRALIA.key -> {
                val view = inflater.inflate(R.layout.item_animal_australia, parent, false)
                AnimalViewHolder(view)
            }

            EContinent.ANTARCTICA.key -> {
                val view = inflater.inflate(R.layout.item_animal_antarctica, parent, false)
                AnimalViewHolder(view)
            }


            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val animalModel = items[position]
        val animalHolder = holder as AnimalViewHolder
        animalHolder.bind(animalModel)
    }


    inner class AnimalViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val animalNameTextView: TextView
        private val continentTextView: TextView
        private val drawable: GradientDrawable

        init {
            animalNameTextView = view.findViewById(R.id.tv_animal_name)
            continentTextView = view.findViewById(R.id.tv_animal_continent)
            drawable = ContextCompat.getDrawable(
                itemView.context,
                R.drawable.rounded_rectangle
            ) as GradientDrawable
        }

        fun bind(animal: AnimalModel) {
            animalNameTextView.text = animal.name
            continentTextView.text = animal.continent.toString()

            this.itemView.setOnClickListener {
                AnimalListFragmentDirections.actionAnimalListFragmentToAnimalPreviewFragment(animal)
                    .also {
                        itemView.findNavController().navigate(it)
                    }
            }
        }
    }
}