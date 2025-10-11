package controller

import model.Carrito
import model.Videojuego
import model.VideojuegoAccion
import model.VideojuegoEstrategia
import model.VideojuegoRpg

class PlataformaJuegos {
    val videojuegos = mutableListOf<Videojuego>()
    val carrito = Carrito()

    fun anadirVideojuego(videojuego: Videojuego){
        videojuegos.add(videojuego)
    }

    fun eliminarVideojuego(videojuego: Videojuego){
        videojuegos.remove(videojuego)
    }

    fun mostrarVideojuegosDeMenorAMayor(){
        val videojuegosMenor = videojuegos.sortedBy { it.precio }
        println("Videojuegos ordenados por precio: ")

        videojuegosMenor.forEach {
            println(it.toString())
            println()
        }
    }

    fun filtrarJuegoEdad(edad: String){
        videojuegos.forEach {
            if(it.clasificacionEdad == edad){
                println(it.toString())
            }
        }
    }

    fun calcularPrecioTodosLosVideojuegos(){
        var precioTotal = 0.0

        videojuegos.forEach {
            precioTotal += it.calcularPrecioFinal()
        }

        println("El precio de todos los videojuegos es: $precioTotal")
    }

    fun listarVideojuegos(){
        videojuegos.forEach {
            println(it.toString())
            println()
        }
    }

    fun listarAccion(){
        videojuegos.forEach {
            if(it is VideojuegoAccion){
                println(it.toString())
            }
        }
    }

    fun listarEstrategia(){
        videojuegos.forEach {
            if(it is VideojuegoEstrategia){
                println(it.toString())
            }
        }
    }

    fun listarRpg(){
        videojuegos.forEach {
            if(it is VideojuegoRpg){
                println(it.toString())
            }
        }
    }

    fun buscarPorId(id: Int){
        val idBuscar = videojuegos.find { it.id == id }
        if (idBuscar != null){
            println(idBuscar.toString())
        }
        else{
            println("No hay ningun videojuego con ese id")
        }
    }

    fun calcularDescarga(id: Int){
        val idBuscar = videojuegos.find { it.id == id }
        if (idBuscar != null){
            println("Digite la velocidad de descarga")
            val velocidad = readln().toDouble()
            idBuscar.calcularTiempoDescarga(velocidad)
        }
        else{
            println("No hay ningun videojuego con ese id")
        }



    }

    fun anadirVideojuegoAlCarrito(id: Int){
        val idEncontrado = videojuegos.find { it.id == id }
        if(idEncontrado != null){
            val coste = idEncontrado.calcularPrecioFinal()
            carrito.anadirVideojuego(coste)
        }else{
            println("No hay videojuego con ese id: ")
        }

    }

    fun quitarVideojuegoCarrito(id: Int){
        val idEncontrado = videojuegos.find { it.id == id }
        if(idEncontrado != null){
            val coste = idEncontrado.calcularPrecioFinal()
            carrito.quitarVideojuego(coste)
        }else{
            println("No hay videojuego con ese id: ")
        }
    }

    fun mostrarPrecioCarrito(){
        carrito.mostrarTotal()
    }

}