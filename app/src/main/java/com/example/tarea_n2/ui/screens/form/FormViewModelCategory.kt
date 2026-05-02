package com.example.tarea_n2.ui.screens.form

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class FormViewModelCategory : ViewModel(){
    var nombre by mutableStateOf("")
    var encargado by mutableStateOf("")
    var listCategory = mutableListOf<Category>()
    var ultimoid = 0

    var nombreError by mutableStateOf<String?>(null)
    var encargadoError by mutableStateOf<String?>(null)

    init {
        cargarDatos()
    }

    fun cargarDatos() {

        val datos = listOf(
            Category(1, "Conciertos", "Juan Perez"),
            Category(2, "Conferencias", "Ana Garcia"),
            Category(3, "Talleres", "Carlos Ruiz")
        )

        listCategory.addAll(datos)
        ultimoid = datos.size
    }

    fun validar(): Boolean {
        var valido = true

        nombreError = if (nombre.isBlank()) "Campo obligatorio" else null
        encargadoError = if (encargado.isBlank()) "Campo obligatorio" else null

        if (nombreError != null || encargadoError != null) valido = false

        return valido
    }

    fun addCategory(){
        if(validar()) {
            ultimoid++
            listCategory.add(Category(ultimoid, nombre, encargado))
            nombre = ""
            encargado = ""
        }
    }
}

class Category(val id:Int, val nombre: String, val encargado: String)