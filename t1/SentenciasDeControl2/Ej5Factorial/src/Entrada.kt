/*Escribe un programa que lea un número entero y que calcule el factorial de ese número.*/

fun main() {
    println("Digite un número: ")
    val numero : Int = readln().toInt()
    var factorial : Int = numero

    if (numero == 1){
        println("El factorial de 1 es 1: ")
    }else{
        for (i in numero-1 downTo 2){
            factorial *= i
        }

        println("EL factorial de $numero es $factorial")
    }

}