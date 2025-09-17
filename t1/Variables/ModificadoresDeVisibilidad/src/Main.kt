//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
   /*Crea un fichero Kotlin con dos clases: `Vehiculo` y `Coche`
   (que hereda de `Vehiculo`). Implementa propiedades y métodos
   con diferentes modificadores de visibilidad (public, private, protected, internal)
   y comenta qué elementos son accesibles desde otra clase en el mismo fichero, desde
   otra clase en otro fichero del mismo paquete, y desde una subclase.*/

    val coche = Coche()

    // --- Accesos desde el mismo paquete---
    coche.velocidad = 120 // public
    coche.acelerar(coche.velocidad)

    // coche.motorEncendido // private no accesible
    // coche.mostrarRuedas() // protected -> solo desde subclases
    coche.mostrarMarca() // internal -> mismo modulo

    coche.mostrarInfoCoche()
}