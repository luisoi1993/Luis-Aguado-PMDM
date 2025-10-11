package model

abstract class Trabajador(var nombre: String,var apellido: String, var dni: String) {

    open fun mostrarDatos(){
        println("El nombre es $nombre")
        println("El apellido es $apellido")
        println("El dni es $dni")
    }

    abstract fun calcularSalarioMensual()

    abstract fun despedido()
}