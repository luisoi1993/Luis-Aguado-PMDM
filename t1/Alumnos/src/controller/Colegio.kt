package controller

import model.Alumno

class Colegio {
    val alumnos = mutableListOf<Alumno>()

    fun listado(){
        var contador = 0
        alumnos.forEach {
            if(it.matriculado){
                contador++
            }

        }
        println("El numero de alumnos matriculados es: $contador")
    }

    fun agregarAlumno(alumno: Alumno){
        alumnos.add(alumno)
    }

    fun buscarId(id : Int): Alumno?{
       return alumnos.find { it.id == id }
    }

    fun calificarAlumno(id: Int,nota: Int){
        val alumnoCalificar = buscarId(id)

        if (alumnoCalificar == null){
            println("No hay ningun alúmno con ese id: ")
        }else{
            if(nota <0){
                println("La nota no puede ser menor que 0, nota asignada 0")
                alumnoCalificar.calificar(0)
            }else if (nota>10){
                println("La nota maxima no puede ser mayor que 10, nota asignada 10")
                alumnoCalificar.calificar(10)
            } else{
                alumnoCalificar.calificar(nota)
                println("Nota asignada correctamente")
            }
        }
    }

    fun darDeBajaAlumno(id: Int){
        val alumnoBaja = buscarId(id)

        if(alumnoBaja == null){
            println("No hay ningun alúmno con ese id: ")
        } else {
            alumnoBaja.desmatricular()
        }
    }

    fun listarTodosAlumnos(){
        alumnos.forEach {
            it.mostrarDatos()
        }
    }

    fun listarAlumnosMatriculados(){
        alumnos.forEach {
            if(it.matriculado){
                it.mostrarDatos()
            }
        }
    }

    fun listarAlumnosNoMatriculados(){
        alumnos.forEach {
            if(!it.matriculado){
                it.mostrarDatos()
            }
        }
    }
}