package com.example.listaanimale.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
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


@Entity(tableName = "animals")
class AnimalModel (
    @PrimaryKey
    @ColumnInfo(name = ARG_ANIMAL_NAME)
    val name: String,
    @ColumnInfo(name = ARG_ANIMAL_CONTINENT)
    var continent: EContinent,
) : Serializable

{
    companion object {
        const val ARG_ANIMAL_NAME = "name"
        const val ARG_ANIMAL_CONTINENT = "continent"
    }
}