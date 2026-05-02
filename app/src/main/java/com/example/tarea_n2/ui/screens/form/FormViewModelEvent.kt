package com.example.tarea_n2.ui.screens.form

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class FormViewModelEvent : ViewModel(){
    var nombre by mutableStateOf("")
    var fecha_hora by mutableStateOf("")
    var lugar by mutableStateOf("")
    var representante by mutableStateOf("")
    var category by mutableStateOf("")
    
    var listEvent = mutableListOf<Event>()
    var ultimoid = 0

    var nombreError by mutableStateOf<String?>(null)
    var fechaHoraError by mutableStateOf<String?>(null)
    var lugarError by mutableStateOf<String?>(null)
    var representanteError by mutableStateOf<String?>(null)
    var categoryError by mutableStateOf<String?>(null)

    init {
        cargarDatos()
    }

    fun cargarDatos() {
        val datos = listOf(
            Event(1, "Final Champions League", "2026-05-30 21:00", "Estadio Wembley", "UEFA", "Conciertos"),
            Event(2, "Concierto Dua Lipa", "2026-06-15 20:00", "Estadio Nacional", "Warner Music",  "Conciertos"),
            Event(3, "Lanzamiento Android 17", "2026-08-10 10:00", "Google HQ", "Google",  "Talleres"),
            Event(4, "Feria Gastronomica", "2026-09-05 12:00", "Parque Bustamante", "Municipalidad",  "Conferencias")
        )

        listEvent.addAll(datos)
        ultimoid = datos.size
    }

    fun validar(): Boolean {
        var valido = true
        nombreError = if (nombre.isBlank()) "Campo obligatorio" else null
        fechaHoraError = if (fecha_hora.isBlank()) "Campo obligatorio" else null
        lugarError = if (lugar.isBlank()) "Campo obligatorio" else null
        representanteError = if (representante.isBlank()) "Campo obligatorio" else null

        categoryError = if (category.isBlank()) "Seleccione una categoría" else null

        if (nombreError != null || fechaHoraError != null || lugarError != null || 
            representanteError != null || categoryError != null) valido = false
        
        return valido
    }

    fun addEvent(){
        if(validar()) {
            ultimoid++
            listEvent.add(Event(ultimoid, nombre, fecha_hora, lugar, representante, category))
            resetForm()
        }
    }

    private fun resetForm() {
        nombre = ""
        fecha_hora = ""
        lugar = ""
        representante = ""
        category = ""
    }
}

class Event(
    val id: Int,
    val nombre: String,
    val fecha_hora: String,
    val lugar: String,
    val representante: String,
    val category: String
)