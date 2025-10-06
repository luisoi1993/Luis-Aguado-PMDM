package model

/*NIvel de responsabilidad 1-5
* sobreescribir mostrarDAtos , calcularSalario neto -> nr >=3  salario + 3% de salario si es menor que 3 - 3%
* metodo disminuir responsabilidad  disminuyo responsabilidad -1 hasta 0
* y metodo aumentar responsabilidad aumenta +1 hasta 5*/

class Jefe(nombre: String, apellido: String, dni: String, salario: Double ,var nResponsabilidad: Int) : Trabajador(nombre,apellido,dni,salario) {

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
}