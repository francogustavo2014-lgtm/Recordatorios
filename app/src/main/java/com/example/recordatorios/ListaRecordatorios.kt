package com.example.recordatorios

import androidx.compose.foundation.lazy.LazyColumn // LazyColumn: es una columna que muestra solo los elementos visibles en pantalla y permite hacer scroll
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.recordatorios.model.Recordatorio

@Composable
fun ListaRecordatorios(
    recordatorios: List<Recordatorio>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(recordatorios) {recordatorio ->
            TarjetaRecordatorio(recordatorio)
        }
    }
}