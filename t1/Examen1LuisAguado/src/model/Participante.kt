package model

class Participante(var nombre: String, var  platilla: MutableList<Jugador>) {
    val id : Int
    var presupuesto: Double
    var puntos: Int = 0

    companion object{
        private var contador = 0

    }

    init {
        contador++
        id = contador
        presupuesto = 100000000.0
    }

    fun anadirParticipante(jugador: Jugador){
        platilla.add(jugador)
    }

    override fun toString(): String {
        return "Participante(nombre='$nombre', platilla=$platilla, puntos=$puntos, id=$id, presupuesto=$presupuesto)"
    }


}