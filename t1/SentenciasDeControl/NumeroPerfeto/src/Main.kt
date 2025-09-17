//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    /*Escribe un programa que lea un número entero positivo y determine si
    es un número perfecto (igual a la suma de sus divisores propios).
    Ejemplo:
    // Entrada
    Introduce un número: 28

    // Salida
    El número 28 es perfecto*/
    print("Introduce un número: ")
    val numero = readln().toInt()

    var sumaDivisores = 0

    for (i in 1 until numero){
        if(numero % i == 0){
            sumaDivisores += i
        }
    }

    if (sumaDivisores == numero) {
        println("El número $numero es perfecto")
    } else {
        println("El número $numero no es perfecto")
    }
}