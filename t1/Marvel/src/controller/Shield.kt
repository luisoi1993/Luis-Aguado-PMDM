package controller

import model.Arma
import model.Superheroe

class Shield {
    val armas = mutableListOf<Arma>()
    val superheroes = mutableListOf<Superheroe>()

    fun crearSuperheroe(superheroe: Superheroe){
        superheroes.add(superheroe)
    }

    fun crearArmas(arma: Arma){
        armas.add(arma)
    }

    fun listarSuperheroes(){
        superheroes.forEach {
            it.toString()
        }
    }

    fun listarArmas(){
        armas.forEach {
            it.toString()
        }
    }

    fun enfrentarSuperheroes(idHeroe1: Int,idHeroe2: Int,idArma1: Int,idArma2: Int){
        val superheroe1 = superheroes.find { it.id == idHeroe1}
        val superheroe2 = superheroes.find { it.id == idHeroe2 }
        val arma1 = armas.find { it.id == idArma1 }
        val arma2 = armas.find { it.id == idArma2 }
        var poderHeroe1 = 0.0
        var poderHeroe2 = 0.0

        if(superheroe1 != null && arma1 != null){
             poderHeroe1 = superheroe1.nivel + (arma1.nivelPotencia * arma1.nivelDanio)

        }else{
            println("El id del superheroe 1 o del arma 1 esta mal")
        }

        if(superheroe2 != null && arma2 != null){
             poderHeroe2 = superheroe2.nivel + (arma2.nivelPotencia * arma2.nivelDanio)

        }else{
            println("El id del superheroe 2 o del arma 2 esta mal")
        }

        if(poderHeroe1 != 0.0 && poderHeroe2 != 0.0){
            if (poderHeroe1 > poderHeroe2){
                println("El ganador es: ")
                println(superheroe1.toString())
            }
            else{
                println("El ganador es: ")
                println(superheroe2.toString())
            }
        }

    }
}