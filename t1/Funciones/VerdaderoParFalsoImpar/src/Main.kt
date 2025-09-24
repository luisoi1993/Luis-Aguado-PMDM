/*Crea una función que tome un número entero y retorne verdadero si es par y falso si es impar.*/

fun main() {
    print(verdaderoParFalsoImpar(3))
}

fun verdaderoParFalsoImpar(numero: Int) : Boolean{
    return if(numero % 2 == 0){
        true
    }
    else {
        false
    }
}