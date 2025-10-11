package model

class VideojuegoRpg(tamanioGB: Double, titulo: String, desarollador: String,
                    anioLanzamiento: Int, precio: Double, clasificacionEdad: String,
                    var mundoAbierto : Boolean,var horasHistoriaPrincipal: Int)
    : Videojuego(tamanioGB,titulo,desarollador,anioLanzamiento,precio,clasificacionEdad) {


    override fun calcularPrecioFinal(): Double {
        var precioFinal = precio
        var precioMundoAbierto = 0.0
        var precioHistoriaPrincipal = 0.0
        var horas = horasHistoriaPrincipal

        if(mundoAbierto){
            precioMundoAbierto = precio * 0.15
        }

        while(horas > 10){
            precioHistoriaPrincipal = precio * 0.02
            precioFinal += precioHistoriaPrincipal
            horas /= 10
        }

        precioFinal += precioMundoAbierto
        return precioFinal
    }

    override fun toString(): String {
        return "VideojuegoRpg(mundoAbierto=$mundoAbierto, horasHistoriaPrincipal=$horasHistoriaPrincipal) ${super.toString()}"
    }
}