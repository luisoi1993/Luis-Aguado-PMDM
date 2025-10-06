//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
  /*Crea un programa en Kotlin que declare dos variables: una variable `var` llamada `contador`
  inicializada a 0, y una constante `val` llamada `LIMITE` con valor 10. Implementa un bucle
  que incremente el contador hasta que alcance el límite y muestre el valor en cada iteración.*/

    var contador : Int = 0
    val LIMITE : Int = 10

    while (contador <= LIMITE){
        println("Contador: $contador")
        contador++
    }
    println("Límite alcanzado")
}