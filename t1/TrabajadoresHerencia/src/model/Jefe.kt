package model

/*NIvel de responsabilidad 1-5
* sobreescribir mostrarDAtos , calcularSalario neto -> nr >=3  salario + 3% de salario si es menor que 3 - 3%
* metodo disminuir responsabilidad  disminuyo responsabilidad -1 hasta 0
* y metodo aumentar responsabilidad aumenta +1 hasta 5*/

class Jefe(nombre: String, apellido: String, dni: String, salario: Double ,var nResponsabilidad: Int) : Trabajador(nombre,apellido,dni,salario),
    Sindicato {

    override fun calcularSalarioNeto(): Double {
        if (nResponsabilidad >= 3){
            salario += (salario *0.03)
        }else {
            salario -= (salario *0.03)
        }
        return salario
    }
    fun aumentarResponsabilidad(){
        if (nResponsabilidad < 5){
            nResponsabilidad++
        }else{
            println("No se puede aumentar mas la responsabilidad")
        }
    }

    fun disminuirResponsabilidad(){
        if (nResponsabilidad > 0){
            nResponsabilidad--
        }else{
            println("No se puede disminuir mas la responsabilidad")
        }
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("nResponsabilidad = ${nResponsabilidad}")
    }

    override fun bajarSueldos(list: ArrayList<Trabajador>): Boolean {
        var baja = false
        println("Digite el nombre del empleado a bajar el sueldo")
        val nombre = readln()
        println("Procedes a bajar los sueldos eres jefe y puedes hacerlo parcialmente")
        list.forEach {
            if (it.nombre == nombre){
                if(it is Jefe){
                    println("No se puede bajar el sueldo ")
                }else{
                    it.salario -= (it.salario * 0.10)
                    baja = true
                }

            } else{
                println("No hay ningun empleado con ese nombre")

            }
        }
        return baja

    }

    override fun calcularBeneficios(): Double {
        println("Como jefe vas a calcular el beneficio de la empresa")
        return  0.0
    }
}