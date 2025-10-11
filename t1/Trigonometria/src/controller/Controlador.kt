package controller

import model.Figura

class Controlador {
    val figuras = mutableListOf<Figura>()

    fun agregarFigura(figura: Figura){
        figuras.add(figura)
    }

    fun mostrarDatosFiguras(){
        figuras.forEach {
            it.mostrarDatos()
            println()
        }
    }
}