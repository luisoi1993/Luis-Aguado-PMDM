//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
   /*Escribe un programa que lea un número entero N y que dibuje un
    triángulo rectángulo de altura N usando asteriscos.
    Ejemplo:
    // Entrada
    Introduce la altura del triángulo: 4

    // Salida
    *
    **
    ***
    *****/

    println("Introduce la altura del triángulo: ")
    val numeroAsteriscos = readln().toInt()

    val asterisco = "*"
    var saltoDeLinea = 1

    for(i in 1..numeroAsteriscos){
        for (j in 1..saltoDeLinea){
            print(asterisco)
        }
        saltoDeLinea++;
        println()
    }
}