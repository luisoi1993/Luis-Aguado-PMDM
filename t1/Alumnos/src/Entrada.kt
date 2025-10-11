import controller.Colegio
import model.Alumno

fun main() {
    val colegio = Colegio()



    do {
        println("Bienvenido al menú del colegio: ")
        println("1: Agregar alúmno: ")
        println("2: Calificar alúmno")
        println("3: Listar alúmnos")
        println("4: Calificar alúmno")
        println("5: Dar de baja a un alúmno")
        println("0: Salir del menú")
        val opcion = readln().toInt()

        when(opcion){
            1 -> {
                println("Digite el nombre: ")
                val nombre = readln()
                println("Digite el apellido: ")
                val apellido = readln()
                println("Digite el telefono")
                val telefono = readln().toInt()
                println("Digite el correo: ")
                val correo = readln()

                val a1 = Alumno(nombre,apellido,telefono,correo)
                colegio.agregarAlumno(a1)
            }

            2 -> {
                println("Digite el Id del alúmno que quieres calificar: ")
                val id = readln().toInt()
                println("Digite la nota a calificar de 1 a 10 ")
                val nota = readln().toInt()
                colegio.calificarAlumno(id,nota)
            }

            3 -> {
                println("1: Digitar todos los alumnos")
                println("2:Digitar alúmnos matriculados")
                println("3:Digitar alúmnos no matriculados")
                val opcionListar = readln().toInt()

                when(opcionListar){
                    1 ->{
                        colegio.listarTodosAlumnos()
                    }
                    2 -> {
                        colegio.listarAlumnosMatriculados()
                    }
                    3 -> {
                        colegio.listarAlumnosNoMatriculados()
                    }
                    else -> {
                        println("Opción no valida: ")
                    }
                }
            }

            4 -> {
                println("Digite el id del alúmno a calificar: ")
                val id = readln().toInt()
                println("Digite la calificación del alúmno: ")
                val calificacion = readln().toInt()
                colegio.calificarAlumno(id,calificacion)
            }

            5 -> {
                println("Digite el id del alúmno para dar de baja: ")
                val id = readln().toInt()
                colegio.darDeBajaAlumno(id)
            }

            0 -> {
                println("Saliendo..... ")
            }

        }
    }while (opcion != 0)
}