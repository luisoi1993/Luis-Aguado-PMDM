/*Crea un array de Strings con los nombres
 de tus profesores de la universidad.
 A continuación, utiliza el método find
 para obtener el primer nombre que contenga la letra 'a'.
 Escribe el nombre en la consola.*/

fun main() {
    val nombres = arrayOf("Luis","Nico","Paco","Borja")

    val primerA = nombres.find { it.contains("a") }

    println("El primer nombre de la lista que contiene a es: $primerA")
}