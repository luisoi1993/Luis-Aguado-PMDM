package controller

import model.Asalariado
import model.Autonomo
import model.Jefe
import model.Trabajador

class Empresa {
    val trabajadores = mutableListOf<Trabajador>()

    fun registrarTrabajador(trabajador: Trabajador){
        trabajadores.add(trabajador)
    }

    fun listarTrabajodores(){
        trabajadores.forEach {
            it.mostrarDatos()
            println()
        }
    }

    fun listarAutonomos(){
        trabajadores.forEach {
            if (it is Autonomo){
                it.mostrarDatos()
                println()
            }
        }
    }

    fun listarAsalariado(){
        trabajadores.forEach {
            if(it is Asalariado){
                it.mostrarDatos()
                println()
            }
        }
    }

    fun mostrarPorDni(dni : String){
       val trabajadorDni = trabajadores.find { it.dni == dni }
        if(trabajadorDni == null){
            println("No hay ningun trabajador con ese dni")
        } else {
            trabajadorDni.mostrarDatos()
        }

    }

    fun despedirTrabajador(dniJefe: String,dniTrabajador: String){
        val jefe = trabajadores.find { it.dni == dniJefe }
        if(jefe != null && jefe is Jefe){
            val trabajador = trabajadores.find { it.dni == dniTrabajador }
            if (trabajador != null ){
                if (trabajador is Asalariado || trabajador is Autonomo){
                    trabajador.despedido()
                }
            }else{
                println("No hay un trabajador con ese dni: ")
            }
        }
    }

    fun comprobarDni(dni: String) : Boolean{
        var dniBoolean: Boolean

        val estaDni = trabajadores.find { it.dni == dni }

        if(estaDni != null){
            dniBoolean = true
        } else {
            dniBoolean = false
        }

        return dniBoolean
    }

    fun comprobarSiHayJefe(): Boolean{
        var hayJefe = false

        trabajadores.forEach {
            if (it is Jefe){
                hayJefe = true
            }
        }

        return hayJefe
    }
}