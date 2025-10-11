import controller.Empresa
import model.Asalariado
import model.Autonomo
import model.Jefe
import java.util.Locale
import java.util.Locale.getDefault

fun main() {

    val empresa = Empresa()

    do {

        println("-------- Bienvenido al menú ---------")
        println("1.Registrar trabajador")
        println("2.Listar trabajadores")
        println("3.Mostrar datos de un trabajador")
        println("4.Despedir trabajador")
        println("0.Salir")
        val opcion = readln().toInt()

        when(opcion){
            1 ->{
                println("Digite el nombre")
                val nombre = readln()
                println("Digite el apellido")
                val apellido = readln()
                println("Digite el dni")
                var dni = readln()
                var estaDni = empresa.comprobarDni(dni)
                while (estaDni){
                    println("El dni ya lo tiene un trabajador de la empresa")
                    println("Digite el dni")
                    dni = readln()
                    estaDni = empresa.comprobarDni(dni)
                }

                println("Eliga que tipo de trabajador quiere crear: ")
                println("1.Asalariado")
                println("2.Autonomo")
                println("3.Jefe")
                val opcionTrabajador = readln().toInt()

                when(opcionTrabajador){
                    1 ->{
                        println("Digite el sueldo")
                        val sueldo = readln().toDouble()
                        println("Digite el número de pagas")
                        val numeroPagas = readln().toInt()
                        println("Digite si se esta contratado o no (s,n)")
                        var contratadoSN = readln().lowercase(getDefault())
                        var contratado: Boolean = true
                        var contadorWhile = 0
                        do {
                            if (contratadoSN == "s"){
                                contratado = true
                                contadorWhile++
                            } else if (contratadoSN == "n"){
                                contratado = false
                                contadorWhile++
                            } else{
                                println("Digitaste mal , solo se puesde elegir s o n")
                                println("Digite si se esta contratado o no (s,n)")
                                 contratadoSN = readln().lowercase(getDefault())
                            }
                        }while (contadorWhile == 0)
                        println("Digite la cuota de la seguridad social")
                        val cuostaSS = readln().toDouble()
                        val tAS = Asalariado(nombre,apellido,dni,sueldo,numeroPagas,contratado,cuostaSS )
                        empresa.registrarTrabajador(tAS)
                    }

                    2 -> {
                        println("Digite el sueldo")
                        val sueldo = readln().toDouble()
                        println()
                        var contratadoSN = readln().lowercase(getDefault())
                        var contratado: Boolean = true
                        var contadorWhile = 0
                        do {
                            if (contratadoSN == "s"){
                                contratado = true
                                contadorWhile++
                            } else if (contratadoSN == "n"){
                                contratado = false
                                contadorWhile++
                            } else{
                                println("Digitaste mal , solo se puesde elegir s o n")
                                println("Digite si se esta contratado o no (s,n)")
                                contratadoSN = readln().lowercase(getDefault())
                            }
                        }while (contadorWhile == 0)
                        val tA = Autonomo(nombre,apellido,dni,sueldo,contratado)
                        empresa.registrarTrabajador(tA)
                    }

                    3 ->{
                        val hayJefe = empresa.comprobarSiHayJefe()

                        if (!hayJefe){
                            println("Digite el número de acciones")
                            val acciones = readln().toInt()
                            println("Digite el beneficio")
                            val beneficio = readln().toInt()
                            println("Digite el sueldo: ")
                            val sueldo = readln().toDouble()

                            val j = Jefe(nombre,apellido,dni,acciones,beneficio,sueldo)
                            empresa.registrarTrabajador(j)
                        } else{
                            println("No se puede crear un jefe por que ya hay un jefe en la empresa")
                        }
                    }
                }

            }
            2 ->{
                println("Que trabajadores quieres listar:")
                println("1.Todos")
                println("2.Asalariados")
                println("3.Autonomos")
                val trabajadoresListar = readln().toInt()

                when(trabajadoresListar){
                    1 ->{
                        empresa.listarTrabajodores()
                    }

                    2 ->{
                        empresa.listarAsalariado()
                    }

                    3 ->{
                        empresa.listarAutonomos()
                    }
                }
            }

            3 ->{
                println("Digite el dni del trabajador que quiere buscar: ")
                val dniTrabajador = readln()
                empresa.mostrarPorDni(dniTrabajador)
            }

            4 ->{
                println("Digite el dni del jefe")
                val dniJefe = readln()
                println("Digite el dni del trabajador")
                val dniTrabajador = readln()

                empresa.despedirTrabajador(dniJefe,dniTrabajador)
            }

            0 -> {
                println("Saliendo.......")
            }
        }
    }while (opcion !=0)
}