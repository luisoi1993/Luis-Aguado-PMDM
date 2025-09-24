/*Crea una función que tome una cadena y retorne el número de caracteres que tiene.*/

fun main() {
    val cadena = "oioioi"
    println(numeroDeCaracteres(cadena))
}

fun numeroDeCaracteres(cadena : String) : Int{
    val longitud = cadena.length
    return longitud
}

