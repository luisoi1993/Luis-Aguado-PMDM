//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    /*Escribe un programa que lea un número entero y que calcule la suma de los primeros N números naturales.
    Ejemplo:
    // Entrada
    Introduce un número: 4

    // Salida
    La suma de los primeros 4 números naturales es: 10*/
    println("Introduce un número: ")
    var numero = readln().toInt()

    println("La suma de los primeros $numero naturales es : ${sumaNumerosNaturales(numero)}")

}

fun sumaNumerosNaturales(num:Int) : Int{
    var suma = 0
    for (i in 1..num){
        suma = suma + i

    }
    return suma
}