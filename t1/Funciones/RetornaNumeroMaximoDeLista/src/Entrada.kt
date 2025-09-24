/*Crea una función que tome una lista de números enteros y retorne el número máximo de la lista.*/

fun main() {
    val numeros = listOf(5, 12, 3, 7, 20, 1)
    println("El número maximo es: ${maximo(numeros)}")
}


fun maximo(lista: List<Int>): Int? {
    if(lista.isEmpty()) return null
    var max = lista[0]
    for(num in lista){
        if ( num > max){
            max = num
        }
    }
    return max
}