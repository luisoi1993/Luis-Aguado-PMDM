package model
/*Extienda de trabajador
* sobreescribar mostrar datos , salario neto salario - (cuostasss * 12)
* metodo pedirDescuento(int/double) rebaja las cuotas en el porcentaje que yo ida solo hace el descuento si tiene seguro
* tiene o no tiene seguro contructor*/
class Autonomo(nombre: String, apellido: String, dni: String, salario: Double, var cuotasSs: Int,   seguro : Boolean)
    : Trabajador(nombre,apellido,dni,salario,seguro) {

    override fun calcularSalarioNeto(): Double {
        salario *= 12
        salario - cuotasSs
        return salario

    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("cuotasSs = ${cuotasSs}")
    }

    fun pedirDescuento(porcentaje : Int){
        if(seguro){
            cuotasSs -= (cuotasSs * porcentaje) / 100
        }
        else{
            println("No tiene seguro")
        }
    }
}