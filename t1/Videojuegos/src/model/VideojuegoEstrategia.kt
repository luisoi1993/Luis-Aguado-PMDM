package model

class VideojuegoEstrategia(tamanioGB: Double, titulo: String, desarollador: String,
                           anioLanzamiento: Int, precio: Double, clasificacionEdad: String,
                           var complejidad: Int, var duracionPartida: Int) : Videojuego(tamanioGB,titulo,desarollador,anioLanzamiento,precio,clasificacionEdad) {

    override fun calcularPrecioFinal(): Double {
        var precioFinal = precio
        var precioComplejidad = 0.0

        for (i in 1..complejidad){
            val precioPorcentaje = precio * 0.03
            precioComplejidad += precioPorcentaje
        }
        precioFinal += precioComplejidad
        return precioFinal

    }

    override fun toString(): String {
        return "VideojuegoEstrategia(complejidad=$complejidad, duracionPartida=$duracionPartida) ${super.toString()}"
    }
}