package com.example.listaanimale

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.ContentFrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listaanimale.adapters.AnimalListAdapter
import com.example.listaanimale.data.models.AnimalModel
import com.example.listaanimale.data.models.EContinent
import com.example.listaanimale.data.repositories.AnimalRepository
import com.example.listaanimale.helpers.extensions.logErrorMessage

class AnimalListFragment : Fragment() {

    private val itemList = ArrayList<AnimalModel>()
    private val adapter = AnimalListAdapter(itemList)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_animal_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAnimalList()
    }

    private fun setupAnimalList() {
        val layoutManager = LinearLayoutManager(context)


        view?.findViewById<RecyclerView>(R.id.rv_animal_list)?.apply {
            this.layoutManager = layoutManager
            this.adapter = this@AnimalListFragment.adapter

            AnimalRepository.getAllAnimals(){ animals ->
                itemList.addAll(animals)
                adapter?.notifyItemChanged(0, itemList.size)
            }
        }

        view?.findViewById<Button>(R.id.btn_add_animal)?.setOnClickListener {

            val fragment = view?.findViewById<ConstraintLayout>(R.id.animal_list_view)

            val name: String = fragment?.findViewById<TextView>(R.id.et_animal_name)?.text.toString()
            val continent: String = fragment?.findViewById<TextView>(R.id.et_animal_continent)?.text.toString()


            if (name.isEmpty() || continent.isEmpty()) {
                AlertDialog.Builder(context)
                    .setTitle("Error")
                    .setMessage("Please fill in all the fields")
                    .setPositiveButton("OK") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .show()
            }
            else if (EContinent.entries.find { it.toString() == continent } == null) {
                AlertDialog.Builder(context)
                    .setTitle("Error")
                    .setMessage("Invalid continent")
                    .setPositiveButton("OK") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .show()
            }
            else {
                val animal = AnimalModel(name, EContinent.entries.find { it.toString() == continent }!!)
                val model : AnimalModel? = itemList.find { it.name.lowercase() == name.lowercase() }

                if (model != null)  model.continent = EContinent.entries.find { it.toString() == continent }!!
                else itemList.add(animal)

                adapter.notifyItemInserted(itemList.size - 1)
                AnimalRepository.insertAnimal(animal)
                {
                    "Animal inserted".logErrorMessage()
                }
            }

        }

    }

    private fun getAnimals(): List<AnimalModel> {
        return listOf(
            AnimalModel("Lion", EContinent.AFRICA),
            AnimalModel("Elephant", EContinent.AFRICA),
            AnimalModel("Polar Bear", EContinent.ANTARCTICA),
            AnimalModel("Kangaroo", EContinent.AUSTRALIA),
            AnimalModel("Tiger", EContinent.ASIA),
            AnimalModel("Koala", EContinent.AUSTRALIA),
            AnimalModel("Grizzly Bear", EContinent.NORTH_AMERICA),
            AnimalModel("Bald Eagle", EContinent.NORTH_AMERICA),
            AnimalModel("Jaguar", EContinent.SOUTH_AMERICA),
            AnimalModel("Capybara", EContinent.SOUTH_AMERICA),
            AnimalModel("Wolf", EContinent.EUROPE),
            AnimalModel("Giraffe", EContinent.AFRICA),
            AnimalModel("Cheetah", EContinent.AFRICA),
            AnimalModel("Hippo", EContinent.AFRICA),
            AnimalModel("Panda", EContinent.ASIA),
            AnimalModel("Elephant Seal", EContinent.ANTARCTICA),
            AnimalModel("Snow Leopard", EContinent.ASIA),
            AnimalModel("Bison", EContinent.NORTH_AMERICA),
            AnimalModel("Moose", EContinent.NORTH_AMERICA),
            AnimalModel("Beaver", EContinent.NORTH_AMERICA),
            AnimalModel("Condor", EContinent.SOUTH_AMERICA),
            AnimalModel("Llama", EContinent.SOUTH_AMERICA),
            AnimalModel("Toucan", EContinent.SOUTH_AMERICA),
            AnimalModel("Koala 2", EContinent.AUSTRALIA),
            AnimalModel("Dingo", EContinent.AUSTRALIA),
            AnimalModel("Emu", EContinent.AUSTRALIA),
            AnimalModel("Penguin", EContinent.ANTARCTICA),
            AnimalModel("Seal", EContinent.ANTARCTICA),
            AnimalModel("Whale", EContinent.ANTARCTICA),
            AnimalModel("Fox", EContinent.EUROPE),
            AnimalModel("Bear", EContinent.EUROPE),
            AnimalModel("Deer", EContinent.EUROPE),
            AnimalModel("Gorilla", EContinent.AFRICA),
            AnimalModel("Rhino", EContinent.AFRICA),
            AnimalModel("Gibbon", EContinent.ASIA),
            AnimalModel("Pangolin", EContinent.ASIA),
            AnimalModel("Red Panda", EContinent.ASIA),
            AnimalModel("Tapir", EContinent.SOUTH_AMERICA),
            AnimalModel("Sloth", EContinent.SOUTH_AMERICA),
            AnimalModel("Anteater", EContinent.SOUTH_AMERICA),
            AnimalModel("Kangaroo Rat", EContinent.AUSTRALIA),
            AnimalModel("Quokka", EContinent.AUSTRALIA),
            AnimalModel("Platypus", EContinent.AUSTRALIA),
            AnimalModel("Penguin", EContinent.ANTARCTICA),
            AnimalModel("Orca", EContinent.ANTARCTICA),
            AnimalModel("Arctic Fox", EContinent.ANTARCTICA),
            AnimalModel("Husky", EContinent.EUROPE),
            AnimalModel("Elk", EContinent.EUROPE),
            AnimalModel("Wild Boar", EContinent.EUROPE)
        )
    }
}