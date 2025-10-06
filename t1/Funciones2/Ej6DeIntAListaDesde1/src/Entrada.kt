/*Crea una función que tome un número entero y que retorne una lista de
los números enteros desde 1 hasta el número ingresado.*/

fun main() {
    println("Digite un numero: ")
    val numero: Int = readln().toInt()

    val lista = listaDesdeUno(numero)

    print("La lista desde el 1 del numero $numero es: ")
    print(lista)
}

fun listaDesdeUno(numero: Int): List<Int>{
    val lista = mutableListOf<Int>()
    for(i in 1..numero){
        lista.add(i)
    }

    return lista
}