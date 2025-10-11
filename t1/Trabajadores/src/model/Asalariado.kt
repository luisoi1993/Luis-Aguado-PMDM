package model

class Asalariado(nombre: String,apellido: String,dni: String,var sueldo: Double,val nPagas: Int,var contratado : Boolean,var cuotaSS: Double)
    : Trabajador(nombre, apellido, dni) {

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("EL sueldo es $sueldo")
        println("El numero de pagas es: $nPagas")
        println("¿Esta contratatado? $contratado")
        println("Cuotas de seguridad social: $cuotaSS")
    }

    override fun calcularSalarioMensual() {
        val salarioMensual = (sueldo - (sueldo * 0.21)) / nPagas
        println("El salario mensual es $salarioMensual")
    }

   override fun despedido(){
        contratado = false
    }
}