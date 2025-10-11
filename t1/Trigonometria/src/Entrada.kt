import controller.Controlador
import model.Circulo
import model.Rectangulo
import model.Triangulo

fun main() {
    val controlador = Controlador()



    do {
        println("Bienvenido al menú: ")
        println("1:Registrar Figura")
        println("2:Mostrar Figuras")
        println("0:Salir")
        val opcion = readln().toInt()

        when(opcion){
            1->{
                println("Eliga el tipo de figura: ")
                println("1:Circulo")
                println("2.Rectangulo")
                println("3.Triangulo")
                val opcionFigura = readln().toInt()

                when(opcionFigura){
                    1->{
                        println("Digite el valor de el radio")
                        val radio = readln().toDouble()
                        val c1 = Circulo(radio)
                        controlador.agregarFigura(c1)
                    }
                    2 ->{
                        println("Digite el valor de la base: ")
                        val base = readln().toDouble()
                        println("Digite el valor de la altura: ")
                        val altura = readln().toDouble()
                        val r1 = Rectangulo(base,altura)
                        controlador.agregarFigura(r1)
                    }
                    3 -> {
                        println("Digite el valor de la base: ")
                        val base = readln().toDouble()
                        println("Digite el valor de la altura: ")
                        val altura = readln().toDouble()
                        val t1 = Triangulo(base,altura)
                        controlador.agregarFigura(t1)
                    }
                }
            }

            2 -> {
                println("La lista de figuras es: ")
                controlador.mostrarDatosFiguras()
            }

            0 ->{
                println("Saliendo....")
            }

            else -> {
                println("Opción no valida")
            }
        }

    }while (opcion !=0)
}