package model

import kotlin.random.Random

class Asalariado(nombre: String,apellido: String,dni: String,salario: Double, var nPagas: Int, var irpf: Double)
    : Trabajador(nombre,apellido,dni,salario) {

    override fun calcularSalarioNeto(): Double {
        // 1000 0.20
        // salario total - lo que te quitan IRPF
        return salario - (salario * irpf)
    }

    // un asalariado puedo pedir un aumento de sueldo
    // se genera un aleatorio entre 1 y 10
    // en caso de generar un numero < 5 no se lo sube el salrio
    //en caso de generar un numero >= 5 se le sube 10% el salario

    fun pedirAumento(){
        val aleatorio = Random.nextInt(1,11)
        if(aleatorio < 5){
            println("No se le sube el salario")
        }else{
            salario + salario * 0.10
        }

    }
    override fun mostrarDatos() {
        super.mostrarDatos()
        println("nPagas = ${nPagas}")
        println("irpf = ${irpf}")
    }
}