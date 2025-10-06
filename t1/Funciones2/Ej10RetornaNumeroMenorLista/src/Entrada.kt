import kotlin.math.min

/*Crea una función que tome una lista de números enteros y que retorne el número menor de la lista.*/


fun main() {
    val listaNumero = mutableListOf<Int>(4,6,8,4,2,1,3,5)
    val minimo = retornaMenor(listaNumero)

    println("El numero minimo de la lista es: $minimo")
}

fun retornaMenor(lista : List<Int>): Int{
    val minimo = lista.min()
    return minimo
}