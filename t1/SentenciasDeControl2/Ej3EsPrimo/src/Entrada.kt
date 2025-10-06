/*Escribe un programa que lea un número entero y que indique si es primo o no.*/

fun main() {
    println("Digite un número: ")
    val numero : Int = readln().toInt()

    var primo : Boolean = true

    if (numero > 1){
        for (i in numero-1 downTo 2){
            if (numero % i == 0){
                primo = false
            }
        }

        if(primo){
            println("El numero $numero es primo: ")
        } else{
            println("El numero $numero no es primo")
        }
    } else{
        println("EL número tiene que ser mayor que 1")
    }

}