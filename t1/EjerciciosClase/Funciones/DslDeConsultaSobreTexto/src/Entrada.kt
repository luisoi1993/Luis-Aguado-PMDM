/* Define funciones de orden superior que permitan construir consultas
   como: texto.buscar { contiene("kotlin") y empiezaCon("fun") o terminaCon(";") }.
   Usa funciones como infix y lambdas.
   Devuelve coincidencias y métricas.
*/

fun main() {
    val texto = """
        fun main() {
        println("Hola Kotlin");
    """.trimIndent()

    println("=== Versión A: lógica original ===")
    val resultadoA = texto.buscar {
        contiene("Kotlin") y empiezaCon("fun") o terminaCon(";")
    }
    println("Coincidencias: ${resultadoA.coincidencias}")
    println("Métricas: ${resultadoA.metricas}")
    println()

    println("=== Versión B: lógica flexible con OR ===")
    val resultadoB = texto.buscar {
        (contiene("Kotlin")) o (empiezaCon("fun")) o (terminaCon(";"))
    }
    println("Coincidencias: ${resultadoB.coincidencias}")
    println("Métricas: ${resultadoB.metricas}")
}

data class ResultadoBusqueda(
    val coincidencias: List<String>,
    val metricas: Map<String, Any>
)

class Filtro(private val condicion: (String) -> Boolean) {
    fun test(linea: String) = condicion(linea)

    infix fun y(otro: Filtro) = Filtro { linea -> this.test(linea) && otro.test(linea) }
    infix fun o(otro: Filtro) = Filtro { linea -> this.test(linea) || otro.test(linea) }
}

fun contiene(sub: String) = Filtro { it.contains(sub, ignoreCase = true) }
fun empiezaCon(prefijo: String) = Filtro { it.startsWith(prefijo) }
fun terminaCon(sufijo: String) = Filtro { it.endsWith(sufijo) }

fun String.buscar(condiciones: () -> Filtro): ResultadoBusqueda {
    val filtro = condiciones()
    val lineas = this.lines()
    val coincidencias = lineas.filter { filtro.test(it.trim()) }

    val metricas = mapOf(
        "totalLineas" to lineas.size,
        "coincidencias" to coincidencias.size,
        "porcentaje" to (coincidencias.size * 100.0 / lineas.size)
    )

    return ResultadoBusqueda(coincidencias, metricas)
}
