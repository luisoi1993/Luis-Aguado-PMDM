/*Escribe un programa que lea un número entero y que muestre por
 pantalla todos los números primos menores o iguales al número leído.*/

fun main() {
    println("Digite un numero: ")
    var numero: Int = readln().toInt()
    var esPrimo : Boolean = true
    while (numero >= 2){
        for (i in numero-1 downTo 2){
            if (numero % i == 0){
                esPrimo = false
            }
        }
        if(esPrimo){
            println("El numero $numero es primo")
        }else{
            println("El numero $numero no es primo")
        }
        esPrimo = true
        numero--
    }
}