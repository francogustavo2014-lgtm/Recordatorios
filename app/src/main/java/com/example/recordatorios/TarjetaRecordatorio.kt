package com.example.recordatorios

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.recordatorios.model.EstadoRecordatorio
import com.example.recordatorios.model.Recordatorio

@Composable
fun TarjetaRecordatorio (recordatorio: Recordatorio) {
    Card(modifier = Modifier.padding(8.dp)) { //"dp" es la unidad de medida de Android, que se adapta al tamaño de pantalla
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = recordatorio.titulo,
                style = MaterialTheme.typography.titleMedium
            )
            Text(text = "Categoria: ${recordatorio.categoria.nombre}")
            Text(text = "Prioridad: ${recordatorio.prioridad.etiqueta}")
            Text(text = "Estado: ${textoEstado(recordatorio.estado)}")
        }
    }
}

private fun textoEstado (estado: EstadoRecordatorio): String {
    return when (estado) {
        is EstadoRecordatorio.Pendiente -> "Pendiente"
        is EstadoRecordatorio.Completado -> "Completado el ${estado.fecha}"
        is EstadoRecordatorio.Vencido -> "Vencido"
    }
}