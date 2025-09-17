//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun esPrimo(n: Int): Boolean {
    if (n < 2) return false
    for (i in 2..Math.sqrt(n.toDouble()).toInt()) {
        if(n % i == 0) {
            return false
        }
    }
    return true
}

fun main() {
    /*Escribe un programa que lea un número entero y que muestre por pantalla todos los números primos menores o iguales al número leído.
    Ejemplo:
    // Entrada
    Introduce un número: 10

    // Salida
    Los números primos menores o iguales a 10 son: 2, 3, 5, 7*/
    println("Digite un numero: ")
    val numero = readln().toInt()

    for(i in numero downTo 2){
        if (esPrimo(i)) {
            println("El numero $i es primo: ")
        }
    }
}