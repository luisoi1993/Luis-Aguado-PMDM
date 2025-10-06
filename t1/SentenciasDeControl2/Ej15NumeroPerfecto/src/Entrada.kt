/*Escribe un programa que lea un número entero
positivo y determine si es un número perfecto
(igual a la suma de sus divisores propios).*/

fun main() {
    println("Digite un número: ")
    val numero = readln().toInt()

    var sumaDivisores = 0

    for (i in 1 until numero){
        if(numero % i == 0){
            sumaDivisores += i
        }
    }

    if(sumaDivisores == numero){
        println("El numero $numero es perfecto")
    }else{
        println("El numero $numero no es perfecto")
    }
}