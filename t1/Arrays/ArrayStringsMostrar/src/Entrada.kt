/*Crea un array de Strings con los nombres de 5 compañeros. A continuación,
 recorre el array y escribe el nombre de cada persona en la consola.*/

fun main() {
    val listaPersonas = arrayOf<String>("Luis","Alba","Alejandra","Vicent","Sara")
    listaPersonas.forEach { println(it) }
}