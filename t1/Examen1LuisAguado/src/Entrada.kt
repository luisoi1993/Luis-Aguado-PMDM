import controller.Fantasy
import model.Administrador
import model.Jugador
import model.Participante
import kotlin.random.Random

fun main() {

    val fantasy = Fantasy()
    fantasy.registrarJugadores()
    val plantilla1 = mutableListOf<Jugador>()
    val plantilla2 = mutableListOf<Jugador>()
    val plantilla3 = mutableListOf<Jugador>()
    val plantilla4 = mutableListOf<Jugador>()

    val p1 = Participante("luis",plantilla1)
    val p2 = Participante("jose",plantilla2)
    val p3 = Participante("eduardo",plantilla3)
    val p4 = Participante("fernando",plantilla4)
    fantasy.anadirParticipante(p1)
    fantasy.anadirParticipante(p2)
    fantasy.anadirParticipante(p3)
    fantasy.anadirParticipante(p4)

    fantasy.ficharJugadores(1)
    fantasy.ficharJugadores(2)
    fantasy.ficharJugadores(3)
    fantasy.ficharJugadores(4)

    val a1 = Administrador("Felipe",4444)
    fantasy.anadirAdministrador(a1)

    fantasy.listarJugadoresMasDe3()

    fantasy.empezarPartida(1)
    fantasy.mostrarGanador()






}