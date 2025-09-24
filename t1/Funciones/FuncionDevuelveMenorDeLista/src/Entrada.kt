/*Crea una función que tome una lista de números enteros y que retorne el número menor de la lista.*/

fun main() {
    val listaEnteros = listOf<Int>(2,4,6,7,1,89)
    println(menorLista(listaEnteros))

}

fun menorLista(listaEnteros : List<Int>) : Int {
    var numeroMenor = listaEnteros[0]

    for (i in 0 until listaEnteros.size){
        if(numeroMenor > listaEnteros[i]){
            numeroMenor = listaEnteros[i]
        }
    }
    return numeroMenor
}