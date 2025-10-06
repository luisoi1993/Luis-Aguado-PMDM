/*Dado un listado de notas 0..10, clasifícalas en Sobresaliente, Notable, Aprobado,
Suspenso pero aplicando una curva según la media del grupo. Usa when y condiciones
sobre media y desviación. Devuelve un resumen con porcentajes y el motivo de la curva.*/


fun main() {
    val notas = listOf(3.5,4.0,6.0,7.5,8.0,9.5,10.0)

    val resumen = clasificarConCurva(notas)
    println(resumen)
}

fun clasificarConCurva(notas: List<Double>): String{
    val media = notas.average()
    val ajuste: Double
    val motivo: String

    when {
        media < 5 -> {
            ajuste = 1.0
            motivo = "La media es baja (${"%.2f".format(media)}), se aplica +1"
        }
        media > 8 -> {
            ajuste = -1.0
            motivo = "La media es alta (${"%.2f".format(media)}), se aplica -1"
        }
        else -> {
            ajuste = 0.0
            motivo = "La media es normal (${"%.2f".format(media)}), no se aplica"
        }
    }

    // Notas ajustadas con curva y Límites 0..10
    val ajustadas = notas.map {(it + ajuste).coerceIn(0.0, 10.0)}

    val clasificaciones = ajustadas.map {
        when {
            it >= 9 -> "Sobresaliente"
            it >= 7 -> "Notable"
            it >= 5 -> "Aprobado"
            else -> "Suspenso"
        }
    }

    val total = clasificaciones.size.toDouble()
    val porcentajes = clasificaciones.groupingBy { it }
        .eachCount().mapValues { (it.value * 100.0 / total) }

    // Generar resumen
    val resumen = buildString {
        appendLine(motivo)
        porcentajes.forEach { (categoria, porcentaje) ->
            appendLine("$categoria: ${"%.2f".format(porcentaje)}%")
        }
    }

    return resumen

}