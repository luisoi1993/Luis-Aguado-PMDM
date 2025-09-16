//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    /*Crea una función que reciba un precio como parámetro nullable (`Int?`)
    y calcule el descuento aplicable. Si el precio es nulo, usa el operador Elvis
    para asignar un valor predeterminado de 100. El descuento será del 10% si el
    precio es mayor que 50, o del 5% en caso contrario.*/

    descuento(null)

    println("--------------")

    descuento(30)
}

fun descuento(precio: Int?) {
    // Si el precio es null, asigna 100
    val precioBase = precio ?: 100

    // Calcular el descuento
    val descuento = if (precioBase > 50) {
        precioBase * 0.10 // 10%
    } else {
        precioBase * 0.05 // 5%
    }

    val precioFinal = precioBase - descuento

    // Mostrar resultados
    println("El precio base es: $precioBase")
    println("EL descuento aplicado es: $descuento")
    println("El precio final es: $precioFinal")
}