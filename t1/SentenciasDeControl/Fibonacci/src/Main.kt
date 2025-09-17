//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    /*Escribe un programa que lea un número entero N y calcule la serie de Fibonacci
     hasta el N-ésimo término.
    Ejemplo:
    // Entrada
    Introduce un número: 7

    // Salida
    Serie de Fibonacci hasta el término 7: 0, 1, 1, 2, 3, 5, */
    println("Introduce un número: ")
    val n = readln().toInt()

    var a = 0
    var b = 1

    print("Serie de Fibonacci hasta el término $n: ")

    for (i in 1..n){
        if (i == n){
            print("$a")
        } else {
            print("$a,")
        }

        val temp = a + b
        a = b
        b = temp
    }
}