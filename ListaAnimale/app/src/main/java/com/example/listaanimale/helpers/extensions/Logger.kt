package com.example.listaanimale.helpers.extensions

import android.util.Log

fun String.logErrorMessage(tag: String = "Lista Animale") {
    Log.e(tag, this)
}