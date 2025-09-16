//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    /*Escribe un programa que declare una variable nullable `var nombre: String?`
    que inicialmente sea `null`. Luego, intenta imprimir la longitud del nombre
    usando el operador de llamada segura (`?.`). Después, asigna un valor a la
    variable y vuelve a imprimir su longitud.*/

    var nombre: String? = null
    println(nombre?.length)

    nombre = "Luis"

    println(nombre.length)
}