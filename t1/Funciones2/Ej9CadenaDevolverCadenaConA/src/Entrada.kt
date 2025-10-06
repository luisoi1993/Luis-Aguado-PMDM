/*Crea una función que tome una lista de cadenas y que retorne una lista de las cadenas que contengan la letra "a".*/

fun main() {
    val lista = mutableListOf<String>("Oi","Sharp","Skinhead","aaa")
    val listaA = devolverSoloA(lista)

    println("La lista con Strings de solo a es: $listaA")
}

fun devolverSoloA(lista: List<String>) : List<String>{
    val listaA = mutableListOf<String>()
    lista.forEach { n ->
        if (n.contains("a")){
            listaA.add(n)
        }
    }

    return listaA
}