/*Escribe un programa que lea un número entero N y que dibuje un triángulo rectángulo de altura N usando asteriscos.*/

fun main() {
    println("Digite el numero de astericos para la piramide: ")
    val numero = readln().toInt()
    val asterisco = "*"
    var contador = 1

    for (i in 1..numero){
        for (i in 1..contador){
            print(asterisco)
        }
        println()
        contador++
    }
}