package com.example.listaanimale

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.listaanimale.data.models.AnimalModel
import com.example.listaanimale.data.models.EContinent.Companion.getColorFromContinent

class AnimalPreviewFragment : Fragment() {

    val arguments: AnimalPreviewFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_animal_preview, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.tv_animal_name)?.text = arguments.animal.name
        view.findViewById<TextView>(R.id.tv_animal_continent)?.text = arguments.animal.continent.toString()
        view.setBackgroundResource(getColorFromContinent(arguments.animal.continent))
    }
}