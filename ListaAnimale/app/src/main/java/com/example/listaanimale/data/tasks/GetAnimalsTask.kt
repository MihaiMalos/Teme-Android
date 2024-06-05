package com.example.listaanimale.data.tasks

import android.os.AsyncTask
import com.example.listaanimale.ApplicationController
import com.example.listaanimale.data.models.AnimalModel

class GetAnimalsTask(
    private val onSuccess: (List<AnimalModel>) -> Unit,
) : AsyncTask<Unit, Unit, List<AnimalModel>>() {
    override fun doInBackground(vararg params: Unit) : List<AnimalModel> {
        return ApplicationController.instance.appDatabase.animalsDao.getAll()
    }

    override fun onPostExecute(result: List<AnimalModel>) {
        onSuccess.invoke(result)
    }


}