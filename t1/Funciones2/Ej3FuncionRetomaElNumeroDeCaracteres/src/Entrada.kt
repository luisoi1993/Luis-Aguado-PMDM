/*Crea una función que tome una cadena y retorne el número de caracteres que tiene.*/

fun main() {
    println("Digite un texto para contar: ")
    val cadena : String = readln()
    println("EL numero de caracteres de la cadena $cadena es : ${contarCadena(cadena)}")
}

fun contarCadena(cadena: String) : Int{
    val numeroDeCaracteres : Int = cadena.length
    return numeroDeCaracteres
}