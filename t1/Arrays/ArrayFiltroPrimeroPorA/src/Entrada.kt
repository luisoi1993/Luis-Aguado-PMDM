/*Crea un array de Strings con los nombres de tus profesores de la universidad. A continuación,
 utiliza el método find para obtener el primer nombre que contenga la letra 'a'. Escribe el nombre en la consola.*/

fun main() {
    val nombres = arrayListOf<String>("Luis","Pedro","Borja")
    val filtroPorA = nombres.find { it.contains("a", ignoreCase = true) }
    println(filtroPorA)
}