package com.example.listaanimale

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listaanimale.adapters.AnimalListAdapter
import com.example.listaanimale.models.AnimalModel
import com.example.listaanimale.models.EContinent

class AnimalListFragment : Fragment() {

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

        val animalList = getAnimals()
        val adapter = AnimalListAdapter(animalList)

        view?.findViewById<RecyclerView>(R.id.rv_animal_list)?.apply {
            this.layoutManager = layoutManager
            this.adapter = adapter
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