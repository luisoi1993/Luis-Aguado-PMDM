package model

class Carrito {
    var total = 0.0

    fun anadirVideojuego(precio: Double){
        total += precio
    }

    fun quitarVideojuego(precio: Double){
        total -= precio
    }

    fun mostrarTotal(){
        println("El precio es $total")
    }
}