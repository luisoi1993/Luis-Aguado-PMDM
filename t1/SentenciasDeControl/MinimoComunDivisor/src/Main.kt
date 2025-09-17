//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    /*Escribe un programa que lea dos números y muestre su máximo común divisor (MCD).
    Ejemplo:
    // Entrada
    Introduce el primer número: 24
    Introduce el segundo número: 36

    // Salida
    El MCD de 24 y 36 es: 12*/
    println("Introduce el primer número: ")
    var num1 = readln().toInt()
    println("Introduce el segundo número: ")
    var num2 = readln().toInt()

    var resto = 1

    print("El MCD  de $num1 y $num2 es: ")
    while (resto != 0){
        resto = num1 % num2
        num1 = num2
        if(resto != 0){
            num2 = resto
        }

    }
    print("$num2")
}