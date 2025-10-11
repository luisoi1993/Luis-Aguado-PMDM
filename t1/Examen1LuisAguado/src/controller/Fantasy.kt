package controller

import model.Administrador
import model.Jugador
import model.Participante
import kotlin.random.Random

class Fantasy {
    val participantes = mutableListOf<Participante>()
    val jugadores = mutableListOf<Jugador>()
    val administradores = mutableListOf<Administrador>()

    fun ficharJugadores(id: Int){
       val participanteFichador = participantes.find { it.id == id }
        var contador = 0
        for (i in 0..6){
            if(participanteFichador != null){
                when(i){
                    0 ->{
                        println("Vamos a fichar al portero")
                        println("Eliga el id del portero")
                        val idPortero = readln().toInt()
                        val portero = jugadores.find { it.id == idPortero }

                        if(portero?.Posicion != "portero" && portero != null){
                            participanteFichador.anadirParticipante(portero)
                        }else{
                            println("El jugador no es portero o el id es invalido")
                        }
                        contador++
                    }
                    1 -> {
                        println("Vamos a fichar al primer defensa")
                        println("Eliga el id del defensa")
                        val idDefensa = readln().toInt()
                        val defensa = jugadores.find { it.id == idDefensa }

                        if(defensa?.Posicion != "defensa" && defensa != null){
                            participanteFichador.anadirParticipante(defensa)
                        }else{
                            println("El jugador no es defensa o el id es invalido")
                        }
                        contador++
                    }

                    2 ->{
                        println("Vamos a fichar al primer defensa")
                        println("Eliga el id del defensa")
                        val idDefensa = readln().toInt()
                        val defensa = jugadores.find { it.id == idDefensa }

                        if(defensa?.Posicion != "defensa" && defensa != null){
                            participanteFichador.anadirParticipante(defensa)
                        }else{
                            println("El jugador no es defensa o el id es invalido")
                        }
                        contador++
                    }

                    3 -> {
                        println("Vamos a fichar al primer medio")
                        println("Eliga el id del medio")
                        val idMedio = readln().toInt()
                        val medio = jugadores.find { it.id == idMedio }

                        if(medio?.Posicion != "medio" && medio != null){
                            participanteFichador.anadirParticipante(medio)
                        }else{
                            println("El jugador no es medio o el id es invalido")
                        }
                        contador++
                    }

                    4 -> {
                        println("Vamos a fichar al segundo medio")
                        println("Eliga el id del medio")
                        val idMedio = readln().toInt()
                        val medio = jugadores.find { it.id == idMedio }

                        if(medio?.Posicion != "medio" && medio != null){
                            participanteFichador.anadirParticipante(medio)
                        }else{
                            println("El jugador no es medio o el id es invalido")
                        }
                        contador++
                    }

                    5 ->{
                        println("Vamos a fichar al delantero")
                        println("Eliga el id del delantero")
                        val idDelantero = readln().toInt()
                        val delantero = jugadores.find { it.id == idDelantero }

                        if(delantero?.Posicion != "delantero" && delantero != null){
                            participanteFichador.anadirParticipante(delantero)
                        }else{
                            println("El jugador no es medio o el id es invalido")
                        }
                        contador++
                    }
                }
            }

        }


    }

    fun empezarPartida(id: Int){
        val administrador = administradores.find { it.id == id }

        if ( administrador != null){
            println("Digite la clave del administrador: ")
            val clave = readln().toInt()
            var aleatorio = 1
            if(administrador.clave == clave){
                participantes.forEach {

                    //val aleatorio = Random(500)
                   // aleatorio as Int
                    //lo haria con aleatorio pero no recuerdo como
                    //generar un aleatorio int
                    it.puntos = aleatorio
                    aleatorio++
                }
            } else {
                println("La clave del administrador no funciona")
            }
        }
        else{
            println("El id del administrador es incorrecto")
        }
    }

    fun listarJugadoresMasDe3(){
        jugadores.forEach {
            if(it.valor > 3000000){
                println(it.toString())
            }
        }
    }

    fun mostrarGanador(){
        var puntuacion = 0
        var ganador : Participante
        participantes.forEach {
            if(it.puntos > puntuacion){
                 ganador = it
                puntuacion = it.puntos
            }
        }

        val ganadorFinal = participantes.find { it.puntos == puntuacion }

        println(ganadorFinal.toString())


    }

    fun anadirParticipante(participante: Participante){
        participantes.add(participante)
    }

    fun anadirAdministrador(administrador: Administrador){
        administradores.add(administrador)
    }

    fun registrarJugadores(){
        jugadores.add(Jugador(1,"Marc-André ter Stegen", "Portero",3000000))
        jugadores.add(Jugador(2,"Ronald Araújo", "Defensa",4000000))
        jugadores.add(Jugador(3,"Eric García", "Defensa",1000000))
        jugadores.add(Jugador(4,"Pedri", "Mediocentro",5000000))
        jugadores.add(Jugador(5,"Robert Lewandowski", "Delantero",8000000))
        jugadores.add(Jugador(6,"Courtois", "Portero",3000000))
        jugadores.add(Jugador(7,"David Alaba", "Defensa",4000000))
        jugadores.add(Jugador(8,"Jesús Vallejo", "Defensa",500000))
        jugadores.add(Jugador(9,"Luka Modric", "Mediocentro",5000000))
        jugadores.add(Jugador(10,"Karim Benzema", "Delantero",8000000))
        jugadores.add(Jugador(11,"Ledesma", "Portero",500000))
        jugadores.add(Jugador(12,"Juan Cala", "Defensa",300000))
        jugadores.add(Jugador(13,"Zaldua", "Defensa",400000))
        jugadores.add(Jugador(14,"Alez Fernández", "Mediocentro",700000))
        jugadores.add(Jugador(15, "Choco Lozano", "Delantero", 800000))
        jugadores.add(Jugador(16,"Rajković", "Portero",300000))
        jugadores.add(Jugador(17,"Raíllo", "Defensa",200000))
        jugadores.add(Jugador(18,"Maffeo", "Defensa",300000))
        jugadores.add(Jugador(19,"Ruiz de Galarreta", "Mediocentro",400000))
        jugadores.add(Jugador(20,"Remiro", "Portero",1000000))
        jugadores.add(Jugador(21,"Elustondo", "Defensa",900000))
        jugadores.add(Jugador(22,"Zubeldia", "Defensa",800000))
        jugadores.add(Jugador(23,"Zubimendi", "Mediocentro",1000000))
        jugadores.add(Jugador(24,"Take Kubo", "Delantero", 800000))
    }
}