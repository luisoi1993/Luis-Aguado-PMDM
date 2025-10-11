import controller.PlataformaJuegos
import model.VideojuegoAccion
import model.VideojuegoEstrategia
import model.VideojuegoRpg
import model.Carrito

fun main() {
    val plataformaJuegos = PlataformaJuegos()
    
    val a1 = VideojuegoAccion(100.0,"Mortal kombat","Bethesda",2000,50.0,"Mayores 18",3,true)
    val a2 = VideojuegoAccion(100.0,"Mortal kombat2","Bethesda",2000,50.0,"Mayores 18",3,true)
    plataformaJuegos.anadirVideojuego(a1)
    plataformaJuegos.anadirVideojuego(a2)
    val r1 = VideojuegoRpg(20.0,"DYD","Larian",2020,40.0,"Mayores 18",true,200)
    val r2 = VideojuegoRpg(20.0,"Baldur Gate","Larian",2020,40.0,"Mayores 18",true,200)
    plataformaJuegos.anadirVideojuego(r1)
    plataformaJuegos.anadirVideojuego(r2)
    val e1 = VideojuegoEstrategia(30.0,"Total War","Pikmin",2020,35.0,"TODOS LOS PUBLICOS",3,20)
    val e2 = VideojuegoEstrategia(30.0,"Total War Warhammer","Pikmin",2020,35.0,"TODOS LOS PUBLICOS",3,20)

    do {
        println("------------ Bienvenido al menú -------------")
        println("1.Ver videojuegos disponibles")
        println("2.Ver videojuegos por categoria")
        println("3.Ver videojuegos filtrados por edad")
        println("4.Mostrar videojuego por id")
        println("5.Calcular tiempo de descarga de un videojuego")
        println("6.Calcular el precio total de todos los videojuegos")
        println("7.Añadir juego al carrito")
        println("8.Quitar juego del carrito")
        println("9.Mostrar total del carrito")
        println("0.Salir")
        val opcion = readln().toInt()

        when(opcion){
            1 ->{
                plataformaJuegos.listarVideojuegos()
            }
            2 ->{
                println("Selecione que videojuegos quiere ver: ")
                println("1.Accion")
                println("2.Estrategia")
                println("3.RPG")
                val opcionElegir = readln().toInt()

                when(opcionElegir){
                    1 ->{
                        plataformaJuegos.listarAccion()
                    }
                    2 -> {
                        plataformaJuegos.listarEstrategia()
                    }
                    3 -> {
                        plataformaJuegos.listarRpg()
                    }

                    else -> {
                        println("Opción no valida")
                    }
                }
            }
            3 ->{
                println("Eliga el filtro")
                val filtro = readln()
                plataformaJuegos.filtrarJuegoEdad(filtro)
            }
            4 ->{
                println("Digite el id a buscar: ")
                val idBuscar = readln().toInt()
                plataformaJuegos.buscarPorId(idBuscar)
            }
            5 ->{
                println("Digite el id a buscar: ")
                val idBuscar = readln().toInt()
                plataformaJuegos.calcularDescarga(idBuscar)
            }

            6 -> {
                plataformaJuegos.calcularPrecioTodosLosVideojuegos()
            }
            7 ->{
                println("Digite el id del videojuego que quieres comprar")
                val idComprar = readln().toInt()
                plataformaJuegos.anadirVideojuegoAlCarrito(idComprar)
            }
            8 -> {
                println("Digite el id del videojuego que quieres vender")
                val idComprar = readln().toInt()
                plataformaJuegos.quitarVideojuegoCarrito(idComprar)
            }
            9 ->{
                plataformaJuegos.mostrarPrecioCarrito()
            }


            0 -> {
                println("Saliendo.... ")
            }


            else -> {
                println("Opción no valida: ")
            }
        }
    }while (opcion != 0)
}