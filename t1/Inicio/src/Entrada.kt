fun main() {
    // comentario de linea
    /*comentario multiple*/
    println("Este es mi primer programa kotlin")
    var nombre = "Borja" // String
    var edad = 40 // Int
    var correo : String? = null
    lateinit var direccion: String
    val DNI = "14135135A"

    // Hola soy Borja , tengo 40 años y mi dni es14311a
    println("hola soy $nombre y tengo $edad y m dni es $DNI")
    println("hola mi $nombre tiene ${nombre.length} letras")
    correo = "luis@gmail.com"
    println("Mi correo es ${correo?.length ?: "no se asignado"}")
    direccion = "Alcorcon"
    println("Mi dirección es $direccion")

}