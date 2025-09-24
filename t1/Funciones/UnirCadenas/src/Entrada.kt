/*Crea una función que tome una lista de cadenas y retorne una cadena
 que contenga todas las cadenas de la lista separadas por espacios.*/

fun main() {
    val cadena : String = "oioi"
    val cadena2 : String = "Sharp"
    val cadenas3 = "Antifa"
    val cadenas = listOf<String>(cadena,cadena2,cadenas3)



    println(juntarCadenas(cadenas))

}

fun juntarCadenas(cadenas : List<String> ) : String {
    val resultado = cadenas.joinToString(" ")
    return resultado
}