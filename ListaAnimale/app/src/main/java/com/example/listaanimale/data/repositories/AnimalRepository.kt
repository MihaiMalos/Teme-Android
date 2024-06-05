package com.example.listaanimale.data.repositories

import com.example.listaanimale.data.models.AnimalModel
import com.example.listaanimale.data.tasks.DeleteAnimalTask
import com.example.listaanimale.data.tasks.GetAnimalsTask
import com.example.listaanimale.data.tasks.InsertAllAnimalsTask
import com.example.listaanimale.data.tasks.InsertAnimalTask

object AnimalRepository {
    fun insertAnimal(animal: AnimalModel, onSuccess: () -> Unit) {
        InsertAnimalTask(onSuccess).execute(animal)
    }
    fun deleteAnimal(animal: AnimalModel, onSuccess: () -> Unit) {
        DeleteAnimalTask(onSuccess).execute(animal)
    }
    fun insertAllAnimals(animals: List<AnimalModel>, onSuccess: () -> Unit) {
        InsertAllAnimalsTask(onSuccess).execute(animals)
    }

    fun getAllAnimals(onSuccess:( List<AnimalModel>) -> Unit) {
        GetAnimalsTask(onSuccess).execute()
    }





}