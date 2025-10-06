import model.Asalariado
import model.Persona
import model.Trabajador
import kotlin.random.Random

fun main() {
    //var persona = Persona("Borja","Martin","fsaf1")
   //persona.mostrarDatos()
    val asalariado = Asalariado("Borja","MArtin","42235234f",1000.5,12,10.0);
    asalariado.pedirAumento()
    asalariado.pedirAumento()
    println(asalariado.calcularSalarioNeto())
}