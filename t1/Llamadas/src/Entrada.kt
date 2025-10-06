import model.Centralita
import model.LlamadaLocal
import model.LlamadaNacional
import model.LlamadaProvincial


fun main() {
    val centralita = Centralita()

    do {
        println("Bienvenido al menú")
        println("1:Registrar llamada")
        println("2:Mostrar costes totales")
        println("3:Mostrar llamadas")
        println("0:Salir")
        val opcion = readln().toInt()

        when(opcion){
            1 ->{
                println("Elige tipo de llamada: ")
                println("1:Llamada local")
                println("2:Llamada provincial")
                println("3:Llamada nacional")
                val numeroLlamada = readln().toInt()

                println("Digite el numero de origen: ")
                val numeroOrigen = readln().toInt()
                println("Digite el número de destino")
                val numeroDestino = readln().toInt()
                println("Digite la duracion de la llamada: ")
                val duracion = readln().toInt()

                when(numeroLlamada){
                    1 ->{
                        val coste = 0
                        val lL = LlamadaLocal(numeroOrigen,numeroDestino,coste,duracion)
                        centralita.registrarLlamadaLocal(lL)
                        centralita.mostrarLlamadas()
                    }

                    2 -> {
                        val coste = duracion * 15
                        val lP = LlamadaProvincial(numeroOrigen,numeroDestino,coste,duracion)
                        centralita.registrarLlamadaProvincial(lP)
                        centralita.mostrarLlamadas()
                    }

                    3 -> {
                        println("Digite la franja (1,2,3)")
                        var franja = readln().toInt()
                        var coste : Int
                        when(franja){
                            1 -> {
                                 coste = duracion * 20
                            }
                            2 -> {
                                coste = duracion * 25
                            }
                            3 -> {
                                coste = duracion * 30
                            }
                            else -> {
                                println("Digitaste mal la franja aplicado el maximo")
                                franja = 3
                                coste = duracion * 30
                            }
                        }

                        val lN = LlamadaNacional(numeroOrigen,numeroDestino,coste,duracion,franja)
                        centralita.registrarLlamadaNacional(lN)
                        centralita.mostrarLlamadas()
                    }

                }
            }

            2 -> {
                println("Las llamadas registradas son: ")
                println()
                centralita.mostrarLlamadas()
            }

            3 -> {
                println("El precio total de todas las llamadas es: ")
                centralita.sumarTodosLosCostes()
            }

          0 -> {
              println("Saliendo......")
          }

          else -> {
              println("Opción no valida: ")
          }
        }

    }while (opcion !=0)
}