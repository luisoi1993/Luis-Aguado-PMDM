package model

abstract class Videojuego(override var tamanioGB: Double,var titulo: String,var desarollador: String,var anioLanzamiento: Int,
var precio: Double,var clasificacionEdad: String) : Descargable {

    val id: Int
    companion object{
        private var contador = 0
    }

    init {
        contador++
        id = contador
    }

    override fun calcularTiempoDescarga(velocidadInternet: Double): Double {
        val tiempoDescarga = tamanioGB / velocidadInternet
        return tiempoDescarga
    }

    override fun obtenerTamanioGB(): Double {
        return tamanioGB
    }

    abstract fun calcularPrecioFinal(): Double
    override fun toString(): String {
        return "Videojuego(id=$id, tamanioGB=$tamanioGB, titulo='$titulo', desarollador='$desarollador', anioLanzamiento=$anioLanzamiento, precio=$precio, clasificacionEdad='$clasificacionEdad')"
    }


}