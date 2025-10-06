/*Escribe un programa que lea un número entero y que calcule la suma de los primeros N números naturales..*/

fun main() {
    println("Digite un número: ")
    val numero : Int = readln().toInt()
    var suma : Int = numero

    if (numero < 1){
        println("El numero no puede ser menor que 1")
    } else if(numero == 1){
        println("El suma del numero 1 es 1")
    }else{
        for (i in 1..<numero){
            suma += i
        }
        println("La suma del numero $numero es $suma")
    }
}