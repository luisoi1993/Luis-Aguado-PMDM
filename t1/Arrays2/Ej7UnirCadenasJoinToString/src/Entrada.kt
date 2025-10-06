/*Crea un array de Strings con los nombres de tus
5 películas favoritas. A continuación, utiliza el método
joinToString para unir los nombres en una sola cadena,
separados por comas. Escribe la cadena resultante en la consola.*/

fun main() {
    val peliculas = arrayOf("Matrix","La comunidad del anillo","Las dos torres","EL retorno del rey","This is england")

    val unionPeliculas = peliculas.joinToString(" ")

    println(unionPeliculas)
}