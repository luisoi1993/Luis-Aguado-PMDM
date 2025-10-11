import controller.Controlador
import model.*

fun main() {
    println("--- INICIANDO PRUEBAS AUTOMÁTICAS ---")

    // Crear tienda
    val tienda = Tienda("TechStore")
    println("\n--- Tienda creada: ${tienda.nombre} ---")
    println("Caja inicial: ${tienda.caja}")

    // Crear cliente
    val cliente = Cliente(1, "Pepe")
    println("Cliente creado: ${cliente.nombre}")

    // Crear productos
    println("\n--- Productos creados ---")
    val p1 = Producto(1, 25.0, Categoria.Tecnologia, "Ratón", "Ratón inalámbrico")
    val p2 = Producto(2, 150.0, Categoria.Tecnologia, "Teclado", "Teclado mecánico RGB")
    val p3 = Producto(3, 500.0, Categoria.Muebles, "Silla gamer", "Color negro y rojo")
    val p4 = Producto(4, 40.0, Categoria.Ropa, "Sudadera", "Sudadera con capucha")
    val p5 = Producto(5, 20.0, Categoria.Ropa, "Camiseta", null)
    val p6 = Producto(6, 80.0, Categoria.Tecnologia, "Auriculares", "Bluetooth")
    val p7 = Producto(7, 999.0, Categoria.Tecnologia, "Portátil", "Alta gama")

    listOf(p1, p2, p3, p4, p5, p6, p7).forEach { it.mostrarDatos() }

    // Agregar productos al almacén
    println("\n--- Agregando productos al almacén ---")
    tienda.agregarProducto(p1)
    tienda.agregarProducto(p2)
    tienda.agregarProducto(p3)
    tienda.agregarProducto(p4)
    tienda.agregarProducto(p5)
    tienda.agregarProducto(p6)
    tienda.agregarProducto(p7) // debería decir "almacén completo"

    // Mostrar almacén
    println("\n--- Almacén actual ---")
    tienda.mostrarAlmacen()

    // Buscar por categoría
    println("\n--- Buscar productos por categoría: TECNOLOGÍA ---")
    tienda.buscarProductosCategoria(Categoria.Tecnologia)

    // Buscar producto por ID
    println("\n--- Buscar producto por ID 3 ---")
    tienda.buscarProductoId(3)

    // Vender producto correcto
    println("\n--- Vender producto con ID 2 ---")
    tienda.venderProducto(2)
    println("Caja después de la venta: ${tienda.caja}")

    // Vender producto inexistente
    println("\n--- Intentar vender producto con ID 99 ---")
    tienda.venderProducto(99)

    // Mostrar almacén tras venta
    println("\n--- Almacén después de vender ---")
    tienda.mostrarAlmacen()

    // Agregar productos al carrito
    println("\n--- Agregar productos al carrito del cliente ---")
    cliente.agregarProductoCarrito(p1)
    cliente.agregarProductoCarrito(p3)
    cliente.agregarProductoCarrito(p5)
    cliente.agregarProductoCarrito(p5) // duplicado

    // Mostrar carrito
    println("\n--- Carrito actual ---")
    cliente.mostrarCarrito()

    // Acceso por posición válida
    println("\n--- Acceder por posición 1 (segundo producto) ---")
    cliente.accesoPorPosicion(1)

    // Acceso por posición inválida
    println("\n--- Acceder por posición fuera de rango ---")
    cliente.accesoPorPosicion(10)

    // Intentar borrar producto con ID duplicado (borrado automático de todos)
    println("\n--- Intentar borrar producto con ID 5 (hay varios) ---")
    cliente.borrarElementosAuto(5, "n")

    // Mostrar carrito tras borrado
    println("\n--- Carrito tras borrar productos ID 5 ---")
    cliente.mostrarCarrito()

    // Pedir factura
    println("\n--- Pedir factura del cliente ---")
    cliente.pedirFactura()

    // Intentar pedir factura sin productos
    println("\n--- Intentar pedir factura sin productos ---")
    cliente.pedirFactura()

    println("\n--- FIN DE LAS PRUEBAS ---")

    val app = Controlador()
    app.iniciar()


}
