/*Escribe un programa que lea un número entero N y calcule la serie de Fibonacci hasta el N-ésimo término.*/

fun main() {
    println("Digite un numero para calcular la serie Fibonacci")
    val numero = readln().toInt()
    var numero1 = 0
    var numero2 = 1
    var temporal = 0

    print("Fibonacci hasta el termino: ")
    for (i in 1..<numero){

        if (i == 1){
            print(numero1)
            print(" ")
        } else{
            temporal = numero1 + numero2
            print(temporal)
            print(" ")
            numero1 = numero2
            numero2 = temporal
        }

    }

}