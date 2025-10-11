package model

class Autonomo(nombre: String,apellido: String,dni: String,var sueldo: Double,var contratado : Boolean)
    : Trabajador(nombre, apellido, dni) {

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("El sueldo es: $sueldo")
        println("¿Esta contratado? $contratado")
    }

    override fun calcularSalarioMensual() {
        val salarioMensual = sueldo / 12
        println("El salario mensual es: $salarioMensual")
    }

   override fun despedido(){
        contratado = false
    }
}