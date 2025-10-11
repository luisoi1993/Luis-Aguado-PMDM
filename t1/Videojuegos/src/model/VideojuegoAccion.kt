package model

class VideojuegoAccion(tamanioGB: Double, titulo: String, desarollador: String,
                       anioLanzamiento: Int, precio: Double, clasificacionEdad: String,
                        var nivelViolencia: Int,var modoMultijador: Boolean) : Videojuego(tamanioGB,titulo,desarollador,anioLanzamiento,precio,clasificacionEdad) {



    override fun calcularPrecioFinal(): Double {
        var precioFinal = precio
        var precioViolencia = 0.0
        var precioMultijugador = 0.0
        if(nivelViolencia > 3){
            precioViolencia = precio * 0.05
        }
        if(modoMultijador){
            precioMultijugador = precio * 0.03
        }
        precioFinal += precioViolencia + precioMultijugador

        return precioFinal
    }

    override fun toString(): String {
        return "VideojuegoAccion(nivelViolencia=$nivelViolencia, modoMultijador=$modoMultijador) ${super.toString()}"
    }
}