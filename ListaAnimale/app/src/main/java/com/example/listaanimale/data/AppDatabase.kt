package com.example.listaanimale.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.listaanimale.data.models.AnimalModel

@Database(entities = [AnimalModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase()
{
    abstract val animalsDao: AnimalsDao
}