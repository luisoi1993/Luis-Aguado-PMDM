package model

class Jefe(nombre: String,apellido: String,dni: String,var acciones : Int,var beneficio: Int,var sueldo: Double) : Trabajador(nombre, apellido, dni ) {

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Las acciones son: $acciones")
        println("El beneficio es: $beneficio")
        println("El sueldo es: $sueldo")
    }

    override fun calcularSalarioMensual() {
        val salarioMensual = sueldo / 12
        println("EL salario mensual es : $salarioMensual")
    }

    override fun despedido() {
        println("No se puede despedir al jefe")
    }
}