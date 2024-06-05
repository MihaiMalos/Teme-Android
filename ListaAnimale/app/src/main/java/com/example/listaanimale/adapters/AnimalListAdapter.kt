package com.example.listaanimale.adapters

import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.listaanimale.AnimalListFragmentDirections
import com.example.listaanimale.R
import com.example.listaanimale.data.models.AnimalModel
import com.example.listaanimale.data.models.EContinent
import com.example.listaanimale.data.repositories.AnimalRepository

class AnimalListAdapter(
    private val items: MutableList<AnimalModel>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int) = items[position].continent.key
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_animal, parent, false)
        return AnimalViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val animalModel = items[position]
        val animalHolder = holder as AnimalViewHolder
        animalHolder.bind(animalModel)
    }


    inner class AnimalViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val animalNameTextView: TextView
        private val continentTextView: TextView
        private val deleteButton: Button

        init {
            animalNameTextView = view.findViewById(R.id.tv_animal_name)
            continentTextView = view.findViewById(R.id.tv_animal_continent)
            deleteButton = view.findViewById(R.id.btn_delete_animal)
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

            deleteButton.setOnClickListener {
                items.removeAt(adapterPosition)
                AnimalRepository.deleteAnimal(animal){}
                notifyItemRemoved(adapterPosition)
            }


        }
    }
}