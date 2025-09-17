//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    /*Escribe un programa que lea un número entero y que calcule el factorial de ese número.
    Ejemplo:
    // Entrada
    Introduce un número: 5

    // Salida
    El factorial de 5 es: 120*/
    println("Introduce un numero: ")
    val numero = readln().toInt()
    println("El factorial de $numero es ${factorial(numero)}")


}

fun factorial(num:Int) : Long{
    var factorial = 1L

    for (i in 2..num){
        factorial *= i;

    }
    return factorial
}