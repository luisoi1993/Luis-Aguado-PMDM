import model.Asalariado
import model.Autonomo
import model.Directivo
import model.Jefe
import model.Persona
import model.Sindicato
import model.Trabajador
import kotlin.random.Random

fun main() {
    //var persona = Persona("Borja","Martin","fsaf1")
   //persona.mostrarDatos()
    val asalariado = Asalariado("Borja","MArtin","42235234f",1000.5,12,10.0);
    val autonomo = Autonomo("Borja","MArtin","42235234f",1000.5,12,true);
    val jefe = Jefe("Borja","MArtin","42235234f",1000.5,1)
    val directivo = Directivo("BorjaDirectivo","Martin","434gf",455435,"sfa@gmail.com",55)
    val trabajadores = arrayListOf<Persona>(asalariado,autonomo,jefe,directivo)

   /* trabajadores.forEach {
        // si eres de tipo trabajador quiero que se calcule l salario
        it.mostrarDatos()
        if(it is Trabajador){
            println("Calculando el salario del trabajador: ${it.calcularSalarioNeto()}")

        }
    }
    */
    //Calcular beneficios
    /*Para podr bajar sueldos, un jefe solo bajara los sueldos
    * a los trabajadores que no son jefes
    * la cantidad de salario que puede bajar es del 10 %
    * en caso de ser directivo, le podre bajar el sueldo a todos los trabajadores
    * incluido a los jefes, un 20 % a los Asalariados/Autonomos
    * un 10% a los jefes*/


    trabajadores.forEach {
        if(it is Sindicato){
            it.bajarSueldos( trabajadores.filter { it !is Directivo  } as ArrayList<Trabajador>)
        }
    }

}