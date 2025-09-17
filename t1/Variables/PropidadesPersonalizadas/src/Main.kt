//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Temperatura {

    var celsius: Double = 0.0
        get() {
            return field
        }
        set(value) {
            when{
                value < -273.15 -> {
                    println("Advertencia la temperatura no puede ser menor que -273.15")
                    field = -273.15
                }
                value > 100 -> {
                    println("Advertencia: la temperatura no puede ser mayor que 100")
                    field = 100.0
                }
                else -> {
                    field = value
                }
            }
        }
}


fun main() {
   /*Define una clase `Temperatura` que tenga una propiedad `celsius`
   con métodos personalizados get y set. El método get debe devolver
   el valor actual, mientras que el set debe validar que la temperatura
  esté entre -273.15°C (cero absoluto) y 100°C. Si el valor está fuera de este rango,
   asigna el valor límite más cercano e imprime un mensaje de advertencia.*/
    val temp = Temperatura()

    // Caso válido
    temp.celsius = 25.0
    println("Temperatura en Celsius: ${temp.celsius}")

    println("---------------")

    // Caso menor que -273.15
    temp.celsius = -300.0
    println("Temperatura en Celsius: ${temp.celsius}")

    println("--------------------")

    // Caso mayor que 100
    temp.celsius = 150.0
    println("Temperatura en Celsius: ${temp.celsius}")


}

