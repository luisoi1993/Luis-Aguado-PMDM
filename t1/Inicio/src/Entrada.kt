var sumaFlecha: ((Int,Int) -> Unit)? = { p1: Int, p2: Int -> println("El resultado de la suma ${p1+p2}") }



fun main() {
    // comentario de linea
    /*comentario multiple*/
    println("Este es mi primer programa kotlin")
    var nombre = "Borja" // String
    var edad = 40 // Int
    var correo : String? = null
    lateinit var direccion: String
    val DNI = "14135135A"

    /*
    println("Introduce tu nombre: ")
    nombre = readln()
    println("Introsuce la edad")
    edad = readln().toInt() // as Int
    saludar(nombre,1)
    saludar(vecesParam = 1,nombreParam = nombre)
    saludar("oi")
    println("El resultado de la operación es. ${sumar(3,5)}")
    sumar(4,7)
    // sumaFlecha = null
    sumaFlecha?.invoke(1,55) ?: "oioi"
    */
    // Hola soy Borja , tengo 40 años y mi dni es14311a
    /*
    println("hola soy $nombre y tengo $edad y m dni es $DNI")
    println("hola mi $nombre tiene ${nombre.length} letras")
    correo = "luis@gmail.com"
    println("Mi correo es ${correo?.length ?: "no se asignado"}")
    direccion = "Alcorcon"
    println("Mi dirección es $direccion")
    */

    repetirFor()



}

fun saludar(nombreParam:String,vecesParam:Int = 1){
    println("Hola $nombreParam, acabas de realizar una función")
}

fun sumar (op1: Int = 0, op2: Int = 0 ): Int {
    return op1.and(op2)
}

fun decidirWhen(valor: Int){

}

fun repetirFor() {

    /*
    for (i in 0..9 step 2){
        println(i)
    }
    */

    //Si la funcion de flecha solo tienen un argumento este se puede llamar con la palabra reservada it
    (20..30).forEach { p -> println(p)}
    (20..30).forEachIndexed { index,item -> println("Elemento en posicion $index con valor $item")  }
   // (20..30).forEachIndexed { index,_ -> println("Elemento en posicion $index con valor $item")  }


}

