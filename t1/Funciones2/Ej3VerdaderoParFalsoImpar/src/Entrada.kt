/*Crea una función que tome un número entero y retorne verdadero si es par y falso si es impar.*/

fun main() {
    println("Digite un número: ")
    var numero : Int = readln().toInt()

    println("Si devuelve true es par si devuelve false es im par :")
    println("El numero $numero: es ${intVerdaderoFalso(numero)}")
}

fun intVerdaderoFalso(numero: Int): Boolean{
    if(numero % 2 == 0){
        return true
    }else{
        return false
    }
}