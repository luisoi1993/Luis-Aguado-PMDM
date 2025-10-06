/*Dada una hora del día y el día de la semana, calcula el precio por kWh según
tramos (valle, llano, punta) y festivos. Usa when con rangos y múltiples
condiciones compuestas. Devuelve además un texto explicativo del tramo aplicado.*/

fun main() {
    val hora = 15
    val dia = "Lunes"

    val (precio,texto) = calcularPrecio(hora,dia)
    println("Hora: $hora:00, Día: $dia")
    println("Precio: $precio eur/KWH")
    println("Tramo: $texto")

}

fun calcularPrecio(hora: Int, dia: String) : Pair<Double, String> {
    val precio: Double
    val texto : String

    when{
        // Festivos (fin de semana)
        dia.equals("Sabado", ignoreCase = true) || dia.equals("Domingo",ignoreCase = true) ->{
            precio = 0.10
            texto = "Tramo Valle (festivo)"
        }

        // Horario Valle
        hora in 0..7 || hora == 23 -> {
            precio = 0.12
            texto = "Tramo Valle"
        }

        // Horario LLano
        hora in 8..17 -> {
            precio = 0.20
            texto = "Tramo Llano"
        }

        // Horario Punta
        hora in 18..22 -> {
            precio = 0.30
            texto = "Tramo Punta"
        }

        else -> {
            precio = 0.0
            texto = "Hora inválida"
        }
    }

    return Pair(precio, texto)
}