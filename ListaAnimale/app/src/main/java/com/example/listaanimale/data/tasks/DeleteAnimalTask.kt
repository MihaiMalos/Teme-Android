package com.example.listaanimale.data.tasks

import android.os.AsyncTask
import com.example.listaanimale.ApplicationController
import com.example.listaanimale.data.models.AnimalModel

class DeleteAnimalTask(
    private val onSuccess: () -> Unit,
) : AsyncTask<AnimalModel, Unit, Unit>(){
    override fun doInBackground(vararg params: AnimalModel) {
        params.getOrNull(0)?.let {animal ->
            ApplicationController.instance.appDatabase.animalsDao.delete(animal)
        }
    }

    override fun onPostExecute(result: Unit?) {
        onSuccess.invoke()
    }


}