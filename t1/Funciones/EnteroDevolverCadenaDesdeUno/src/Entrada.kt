/*Crea una función que tome un número entero y que retorne una lista de los números
 enteros desde 1 hasta el número ingresado.*/

fun main() {
    val numero = 7
    val resultado = listaNumeros(numero)
    println(resultado.contentToString())

}

fun listaNumeros(numero : Int) : Array<Int> {
    val numeros = mutableListOf<Int>()

    for (i in 1..numero){
        numeros.add(i)
    }

    return numeros.toTypedArray()
}