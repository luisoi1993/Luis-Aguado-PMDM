package model

class Directivo(nombre: String,apellido: String,dni: String,telefono: Int,correo: String, var nAccines : Int
) : Persona(nombre,apellido,dni,telefono,correo), Sindicato {

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("nAccines = ${nAccines}")
    }

    fun venderAcciones(acciones: Int){
        if(acciones > nAccines){
            println("No puedes vender tantas accione")
        } else{
            nAccines -= acciones
            println("Numero de acciones actualizadas")
        }
    }
    /*Para podr bajar sueldos, un jefe solo bajara los sueldos
    * a los trabajadores que no son jefes
    * la cantidad de salario que puede bajar es del 10 %
    * en caso de ser directivo, le podre bajar el sueldo a todos los trabajadores
    * incluido a los jefes, un 20 % a los Asalariados/Autonomos
    * un 10% a los jefes*/
    override fun bajarSueldos(list: ArrayList<Trabajador>): Boolean {

        list.forEach {
            if(it is Jefe){
                it.salario *= 0.1
            }else {
                it.salario *= 0.2
            }
        }
        return true
    }

    override fun calcularBeneficios(): Double {
        println("Como directivo vas a calcular el beneficio de la empresa")
        return  0.0
    }


}