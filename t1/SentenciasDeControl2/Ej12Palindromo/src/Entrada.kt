/*Escribe un programa que lea un número entero N y que compruebe si es
un número palíndromo (se lee igual de izquierda a derecha que de derecha a izquierda).*/

fun main() {
    println("Digite un número: ")
    val numero = readln()
    val reverso = numero.reversed()

    if(numero == reverso){
        println("Es palindromo")
    }else{
        println("El numero $numero no es palindromo")
    }
}

