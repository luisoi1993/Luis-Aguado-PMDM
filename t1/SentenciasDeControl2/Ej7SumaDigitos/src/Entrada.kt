import kotlin.collections.plusAssign
import kotlin.compareTo
import kotlin.div
import kotlin.math.abs
import kotlin.rem

/*Escribe un programa que lea un número entero y que calcule la suma de los dígitos de ese número.*/

fun main() {
    println("Digite un numero")
    var numero : Int = readln().toInt()
    var suma = 0
    var resto : Int

    if(numero < 10 && numero > -1){
        println("La suma de los digitos es $numero")
    }else if (numero < 0){
       var positivo = abs(numero)

       while (positivo > 0){
            resto = positivo % 10
            positivo /= 10
            suma += resto
        }

        println("La suma  es $suma")
    }
    else{
        while (numero > 0){
            resto = numero % 10
            numero /= 10
            suma += resto
        }

        println("La suma  es $suma")
    }
}

