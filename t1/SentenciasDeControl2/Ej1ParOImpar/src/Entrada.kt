/*Escribe un programa que lea un número entero y que indique si es par o impar.*/

fun main() {
    println("Digite un número: ")
    val numero : Int = readln().toInt()

    if(numero % 2 == 0){
        println("El numero $numero es par")
    } else{
        println("El numero $numero es impar")
    }
}