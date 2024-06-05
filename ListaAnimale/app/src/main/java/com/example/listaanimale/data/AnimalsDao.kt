package com.example.listaanimale.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.listaanimale.data.models.AnimalModel

@Dao
interface AnimalsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(animal: AnimalModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(products: List<AnimalModel>)

    @Query("SELECT * FROM animals")
    fun getAll(): List<AnimalModel>

    @Delete
    fun delete(animal: AnimalModel)
}