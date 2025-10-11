package model

class Alumno(var nombre: String,var apellido: String,var telefono: Int? =null,var correo: String? = null,var calificaion : Int = 0,var matriculado : Boolean = true) {
    val id: Int

    companion object{
        private var contador = 0
        fun generarId() : Int{
            contador++
            return contador
        }
    }

    init {

        id = generarId()
    }

    fun mostrarDatos(){
        println("El id es $id")
        println("El nombre es $nombre")
        println("El telefono es ${telefono ?: "Dato no disponible "}")
        println("El correo es ${correo ?: "Dato no disponible "}")
        println("La calificación es $calificaion")
        println("¿Esta matriculado? $matriculado")
        println("--------------------------------------")
    }

    fun desmatricular(){
        matriculado = false
    }

    fun calificar(nota: Int){
        calificaion = nota
    }
}