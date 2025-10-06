package model

abstract class Persona(var nombre: String, var apellido: String,var dni: String) {
    var telefono: Int? = null

    var correoE : String? = null



    constructor(nombre: String,apellido: String,dni: String,telefono: Int, correoE: String):this(nombre,apellido,dni) {
        this.telefono
        this.correoE
    }
    open fun mostrarDatos(){
        println("EL nombre es: $nombre")
        println("El apellido es: $apellido")
        println("EL dni es : $dni")
        println("El telefono es: ${telefono ?: "NO se ha expecificado"}")
        println("El correo es: ${correoE ?: "No se ha expecificado"}")
    }
    //nombre, apelliedo , dni obligatorio
    //opcional telefono correo
}