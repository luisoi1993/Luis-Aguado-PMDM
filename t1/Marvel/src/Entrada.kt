import controller.Shield
import model.ArmaBiologica
import model.ArmaTradicional
import model.Humano
import model.Mutante

fun main() {

    val shield = Shield()
    val t1 = ArmaTradicional("Telaraña",5.0,10.0,25.0)
    shield.crearArmas(t1)
    val b1 = ArmaBiologica("Rayos x",15.0,20.0,"Rayos oculares")
    shield.crearArmas(b1)
    val h1 = Humano("Spiderman",5.0,20.0,t1)
    shield.crearSuperheroe(h1)
    val m1 = Mutante("Ciclope",3.0,10.0,b1)

    do {
        println("Bienvenido a SHIELD")
        println("1.Crear superheroe")
        println("2.Listar superheroes")
        println("3.Listar armas")
        println("4.Enfrentar superheroes")
        val opcion = readln().toInt()

        when(opcion){
            1 ->{
                println("Primero digite los datos del arma")
                println("Digite el nombre del arma: ")
                val nombreArma = readln()
                println("Digite el nivel del arma")
                val nivelArma = readln().toDouble()
                println("Elige el tipo de superheroe")
                println("1.Humano")
                println("2.Mutante")
                val opcionSuper = readln()
            }
        }
    }while(opcion != 0)
}