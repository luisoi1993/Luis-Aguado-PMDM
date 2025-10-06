/*Crea funciones parciales para procesar pedidos: validar -> aplicarDescuentos -> calcularImpuestos -> totalizar.
Usa composición de funciones y parámetros por defecto. Permite activar o desactivar pasos con banderas.*/


data class Pedido(
    val id: Int,
    val cliente: String,
    var subtotal: Double,
    var descuento: Double = 0.0,
    var impuestos: Double = 0.0,
    var total: Double = 0.0
)

// --- Funciones individuales ---
fun validar(pedido: Pedido): Pedido {
    require(pedido.subtotal > 0) { "El subtotal debe ser mayor que 0" }
    println("✅ Pedido ${pedido.id} validado correctamente.")
    return pedido
}

fun aplicarDescuentos(pedido: Pedido): Pedido {
    pedido.descuento = pedido.subtotal * 0.10
    println("💸 Se aplicó un descuento del 10%: -${pedido.descuento}")
    return pedido
}

fun calcularImpuestos(pedido: Pedido): Pedido {
    pedido.impuestos = (pedido.subtotal - pedido.descuento) * 0.21
    println("💰 Impuestos aplicados (21%): +${pedido.impuestos}")
    return pedido
}

fun totalizar(pedido: Pedido): Pedido {
    pedido.total = pedido.subtotal - pedido.descuento + pedido.impuestos
    println("🧾 Total final del pedido: ${pedido.total}")
    return pedido
}

// --- Función de composición ---
fun procesarPedido(
    pedido: Pedido,
    validarActivo: Boolean = true,
    descuentosActivos: Boolean = true,
    impuestosActivos: Boolean = true,
    totalizarActivo: Boolean = true
): Pedido {
    // Lista de funciones a aplicar
    val pasos = mutableListOf<(Pedido) -> Pedido>()

    if (validarActivo) pasos.add(::validar)
    if (descuentosActivos) pasos.add(::aplicarDescuentos)
    if (impuestosActivos) pasos.add(::calcularImpuestos)
    if (totalizarActivo) pasos.add(::totalizar)

    // Composición funcional con fold
    return pasos.fold(pedido) { acc, funcion -> funcion(acc) }
}

// --- Programa principal ---
fun main() {
    val pedido1 = Pedido(id = 1, cliente = "Juan Pérez", subtotal = 1000.0)

    println("=== Procesando pedido completo ===")
    procesarPedido(pedido1)

    println("\n=== Procesando pedido sin impuestos ni descuentos ===")
    val pedido2 = Pedido(id = 2, cliente = "María López", subtotal = 800.0)
    procesarPedido(pedido2, descuentosActivos = false, impuestosActivos = false)
}
