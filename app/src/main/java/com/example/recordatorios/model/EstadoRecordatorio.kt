package com.example.recordatorios.model

sealed class EstadoRecordatorio {
    object Pendiente : EstadoRecordatorio ()
    data class Completado (val fecha: String) : EstadoRecordatorio ()
    object Vencido : EstadoRecordatorio ()
}