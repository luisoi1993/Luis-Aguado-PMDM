package model

class Centralita {
    val llamadas = mutableListOf<Llamada>()

    fun registrarLlamadaLocal(local: LlamadaLocal){
        llamadas.add(local)
    }

    fun registrarLlamadaProvincial(provincial: LlamadaProvincial){
        llamadas.add(provincial)
    }

    fun registrarLlamadaNacional(nacional: LlamadaNacional){
        llamadas.add(nacional)
    }

    fun sumarTodosLosCostes(){
        var precioTotal: Int = 0
        llamadas.forEach {
            precioTotal += it.coste
            println("El precio de todas las llamadas es: $precioTotal")
        }
    }

    fun mostrarLlamadas(){
        llamadas.forEach {
            it.mostrarDatos()
            println()
        }
    }
}