/*Escribe un programa que lea dos números y muestre su máximo común divisor (MCD).*/

fun main() {
    println("Digite el primer número: ")
    var numero1 = readln().toInt()
    println("Digite el segundo número: ")
    var numero2 = readln().toInt()

    while(numero2 !=0){
        var temporal = numero2
        numero2 = numero1 % numero2
        numero1 = temporal
    }
    println("El Maximo Común Divisor es:  $numero1" )
}