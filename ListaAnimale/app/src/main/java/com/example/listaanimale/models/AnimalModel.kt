package com.example.listaanimale.models

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
        return when(this) {
            EUROPE -> "Europe"
            AFRICA -> "Africa"
            ASIA -> "Asia"
            NORTH_AMERICA -> "North America"
            SOUTH_AMERICA -> "South America"
            AUSTRALIA -> "Australia"
            ANTARCTICA -> "Antarctica"
        }
    }
}

class AnimalModel (
    val name: String,
    val continent: EContinent,
)