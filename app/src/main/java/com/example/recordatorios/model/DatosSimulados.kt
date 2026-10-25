package com.example.recordatorios.model

object DatosSimulados {

    val estudio = Categoria(1, "Estudio")
    val trabajo = Categoria(2, "Trabajo")
    val hogar = Categoria(3, "Hogar")

    val Categoria: Set<Categoria> = setOf( //esto crea el set con los elementos que se pase
        estudio,
        trabajo,
        hogar,
        Categoria(1, "Estudio")
    )
    val coloresPorCategoria: Map<Categoria, Long> = mapOf( //mapof crea el map con los pares q se introduzcan y long es para guardar solamente el numero
        estudio to 0xFF3F51B5, //to arma un par "clave y valor" color: azul es
        trabajo to 0xFFFF9800,
        hogar to 0xFF4CAF50
    )
    val recordatorios: List<Recordatorio> =listOf(
        Recordatorio(
            id = 1,
            titulo = "Entrega Actividad 1",
            descripcion = "Subir el PDF",
            categoria = estudio,
            prioridad = Prioridad.Alta,
            fechaLimite = "25/10/2026"
        ),

        Recordatorio (
            id = 2,
            titulo = "Repasar Kotlin",
            categoria = estudio,
            prioridad = Prioridad.Media
        ),

        Recordatorio (
            id = 3,
            titulo = "Reunion con cliente",
            categoria = trabajo,
            prioridad = Prioridad.Alta,
            estado = EstadoRecordatorio.Vencido,
            fechaLimite = "20/10/2026"
        ),

        Recordatorio (
            id = 4,
            titulo = "Comprar materiales",
            descripcion = "Cables y fichas",
            categoria = hogar,
            prioridad = Prioridad.Baja
        ),

        Recordatorio (
            id = 5,
            titulo = "Pagar internet",
            categoria = hogar,
            prioridad = Prioridad.Media,
            estado = EstadoRecordatorio.Completado ("21/10/2026")
        )
    )
    fun pendientes(): List<Recordatorio> {
        return recordatorios.filter { it.estado is EstadoRecordatorio.Pendiente } // Recorre la lista recordatorios y arma una lista nueva con los que cumplen la condición de las llaves
    }
    fun porPrioridad(prioridad: Prioridad): List<Recordatorio> {
        return recordatorios.filter { it.prioridad == prioridad}
    }
}
// Los recordatorios 1,2 y 4 no puse "estado", porque quedan en pendiente, queda por defecto por el valor de la data class
// Los recordatorios 3 y 5 si puse estados pero distintos, porque en completado lleva una fecha entre parentesis, y es porque la data class lleva un dato extra