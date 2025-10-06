import java.util.Locale
import java.util.Locale.getDefault

/*Escribe un programa que lea un número entero y que muestre por pantalla su representación en hexadecimal.*/

fun main() {
    println("Digite un número:")
    val numero: Int = readln().toInt()
    val hexadecimal = numero.toString(16).uppercase(getDefault())

    println("El numero $numero en hexadecimal es $hexadecimal")
}