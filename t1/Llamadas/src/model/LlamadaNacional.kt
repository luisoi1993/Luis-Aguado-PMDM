package model

class LlamadaNacional( nOrigen: Int, nDestino: Int, coste: Int, duracion: Int ,var franja: Int): Llamada(nOrigen,nDestino,coste,duracion) {

    override fun mostrarDatos() {
        println("El numero de origen es $nOrigen")
        println("El numero de destino es $nDestino")
        println("El coste es $coste")
        println("La duración es $duracion")
        println("La franja es $franja")
    }
}