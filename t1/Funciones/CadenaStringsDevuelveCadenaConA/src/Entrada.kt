/*Crea una función que tome una lista de cadenas y
que retorne una lista de las cadenas que contengan la letra "a"*/

fun main() {
    val listaCadenas = arrayListOf<String>("Skin","Sharp","oi","Alba")
    val resultado = filtrarConA(listaCadenas)
    println(resultado)
}

fun filtrarConA(cadenas: List<String>): List<String>{
    return cadenas.filter { it.contains("a", ignoreCase = true) }
}

