package model

abstract class Llamada(var nOrigen: Int,var nDestino: Int,var coste: Int,var duracion: Int) {

    abstract fun mostrarDatos()
}