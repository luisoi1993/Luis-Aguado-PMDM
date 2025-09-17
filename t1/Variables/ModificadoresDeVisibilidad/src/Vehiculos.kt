open class Vehiculo {

    public var velocidad: Int = 0 // accesible desde cualquier sitio
    private var motorEncendido: Boolean = false // solo accesible dentro de vehiculo
    protected var ruedas: Int = 4 // Accesible en Vehiculo y subclases
    internal  var marca: String = "Generica" //accesible dentro del mismo módulo

    public fun acelerar(nuevaVelocidad: Int) {
        velocidad = nuevaVelocidad
        println("EL vehículo acelera a $velocidad km/h")
    }

    private fun encenderMotor() {
        motorEncendido = true
        println("Motor encendido")
    }

    protected fun mostrarRuedas() {
        println("El vehículo tiene $ruedas ruedas")
    }

    internal fun mostrarMarca() {
        println("Marca: $marca")
    }
}

class Coche : Vehiculo() {

    fun mostrarInfoCoche() {
        // Se puede acceder a propiedades y métodos public y protected
        println("La velocidad del coche es: $velocidad Km/h") // Public
        // println(motorEncendido) // Error private en vehiculo
        mostrarRuedas() // si: protected
        mostrarMarca() // si: internal
    }
}