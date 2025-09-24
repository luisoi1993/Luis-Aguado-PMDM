/*Crea un array de Strings con los nombres de tus 5 películas favoritas. A continuación,
 utiliza el método joinToString para unir los nombres en una sola cadena, separados por comas.
 Escribe la cadena resultante en la consola.*/

fun main() {
    val peliculas = arrayOf("El señor de los anillos","Matrix","Las dos torres","Infinity war","End game")
    val unionPeliculas = peliculas.joinToString(" ")
    println(unionPeliculas)
}