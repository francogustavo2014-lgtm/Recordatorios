package com.example.recordatorios.model

data class Recordatorio ( // solo se guarda datos
    val id: Int,
    val titulo: String,
    val descripcion: String? = null, // ? significa que puede ser opcional
    val categoria: Categoria,
    val prioridad: Prioridad,
    val estado: EstadoRecordatorio = EstadoRecordatorio.Pendiente,
    val fechaLimite: String? = null

)