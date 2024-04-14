package com.example.listaanimale.models

import com.example.listaanimale.R
import java.io.Serializable

enum class EContinent (
    val key: Int
) {
    EUROPE(0),
    AFRICA(1),
    ASIA(2),
    NORTH_AMERICA(3),
    SOUTH_AMERICA(4),
    AUSTRALIA(5),
    ANTARCTICA(6);

    override fun toString(): String {
        return when (this) {
            EUROPE -> "Europe"
            AFRICA -> "Africa"
            ASIA -> "Asia"
            NORTH_AMERICA -> "North America"
            SOUTH_AMERICA -> "South America"
            AUSTRALIA -> "Australia"
            ANTARCTICA -> "Antarctica"
        }
    }

    companion object {
        fun getColorFromContinent(continent: EContinent): Int {
            return when (continent) {
                EUROPE -> R.color.green
                AFRICA -> R.color.yellow
                ASIA -> R.color.red
                NORTH_AMERICA -> R.color.brown
                SOUTH_AMERICA -> R.color.orange
                AUSTRALIA -> R.color.purple
                ANTARCTICA -> R.color.blue
            }

        }


    }
}


class AnimalModel (
    val name: String,
    val continent: EContinent,
) : Serializable