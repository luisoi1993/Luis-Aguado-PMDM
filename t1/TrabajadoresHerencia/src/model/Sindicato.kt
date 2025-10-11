package model

interface Sindicato {

     fun bajarSueldos(list: ArrayList<Trabajador>): Boolean
     fun calcularBeneficios(): Double
}