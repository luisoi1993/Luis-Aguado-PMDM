/*Crea una función que tome una lista de cadenas y retorne
 una cadena que contenga todas las cadenas de la lista separadas por espacios.*/

fun main() {
    val cadenas = listOf<String>("Skinhead", "oi", "Sharp","Punk")

    println("Las cadenas juntas es: ${juntarCadena(cadenas)}")
}

fun juntarCadena(lista: List<String>): String{
    val cadenasJuntas : String = lista.joinToString(" ")

    return cadenasJuntas
}