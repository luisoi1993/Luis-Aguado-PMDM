/*Simula un flujo de compra con saldo, selección de producto y cambio. Debes manejar errores con when
: producto no válido, saldo insuficiente, falta de cambio. Devuelve códigos de estado y mensajes.*/

fun main() {
    val productos : List<Pair<String, Double>> = listOf(
            "Chocolatina" to 1.00,
            "Refresco" to 0.50,
            "Pipas" to 0.30)
    var dineroCliente = 1.00
    var dineroMaquina = 1000.00

do {
    println("Bienvenido a la maquina expendedora: ")
    println("1.Mostrar productos disponibles: ")
    println("2.Elegir producto: ")
    println("3.Salir: ")
    val numero = readln().toInt()

    when(numero){
        1 -> {
            productos.forEach {
                println(it)
            }
        }

        2 -> {
            var contador = 1
            println("Selecione el producto")
            productos.forEach {
                println("$contador : $it")
                contador++
            }
            println("Eliga un producto")
            val seleccionProducto = readln().toInt()
            val seleccion = productos[seleccionProducto-1]
            val nombre = seleccion.first
            val precio = seleccion.second
            println("Ha seleccionado $nombre y cuesta $precio")
            if(dineroCliente < seleccion.second){
                println("No tienes dinero suficiente")
            } else {
                dineroCliente -= precio
                dineroMaquina += precio
                println("Dinero en la tarjeta: $dineroCliente")
                println("Dinero en la maquina: $dineroMaquina")
            }


        }

        3 -> {
            println("Saliendo de la maquina")
        }
    }
} while (numero != 3)
}