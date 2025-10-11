package controller

import model.*

class Controlador {


    private val tienda = Tienda("TechStore")
    private val cliente = Cliente(1, "Pepe")

    fun iniciar() {
        var opcion: Int

        do {
            mostrarMenu()
            opcion = readln().toIntOrNull() ?: -1

            when (opcion) {
                1 -> agregarProductoTienda()
                2 -> tienda.mostrarAlmacen()
                3 -> venderProductoTienda()
                4 -> agregarProductoCarritoCliente()
                5 -> cliente.mostrarCarrito()
                6 -> cliente.borrarElementos(leerId("producto a eliminar del carrito"))
                7 -> cliente.pedirFactura()
                8 -> buscarPorCategoria()
                0 -> println("Saliendo del programa...")
                else -> println("Opción no válida.")
            }
        } while (opcion != 0)
    }

    private fun mostrarMenu() {
        println(
            """
            
            ========= MENÚ PRINCIPAL =========
            1. Agregar producto al almacén
            2. Mostrar productos del almacén
            3. Vender producto de la tienda
            4. Agregar producto al carrito del cliente
            5. Mostrar carrito del cliente
            6. Eliminar producto del carrito
            7. Pedir factura
            8. Buscar productos por categoría
            0. Salir
            ==================================
            Elige una opción:
            """.trimIndent()
        )
    }

    private fun agregarProductoTienda() {
        println("=== AGREGAR PRODUCTO ===")
        val id = leerId("nuevo producto")

        println("Introduce el nombre del producto:")
        val nombre = readln()

        println("Introduce el precio:")
        val precio = readln().toDoubleOrNull() ?: 0.0

        println("Introduce la descripción:")
        val descripcion = readln()

        println("Selecciona la categoría:")
        Categoria.values().forEachIndexed { index, cat -> println("${index + 1}. $cat") }
        val catIndex = readln().toIntOrNull() ?: 4
        val categoria = Categoria.values().getOrNull(catIndex - 1) ?: Categoria.Generica

        val producto = Producto(id, precio, categoria, nombre, descripcion)

        // Ahora comprobamos si se ha agregado correctamente
        val agregado = tienda.agregarProducto(producto)
        if (agregado) {
            println("Producto agregado correctamente al almacén.")
        }
    }


    private fun venderProductoTienda() {
        println("=== VENDER PRODUCTO ===")
        val id = leerId("producto a vender")
        tienda.venderProducto(id)
        println("Venta procesada. Caja actual: ${tienda.caja}")
    }

    private fun agregarProductoCarritoCliente() {
        println("=== AGREGAR PRODUCTO AL CARRITO ===")
        val id = leerId("producto a agregar desde el almacén")

        // Buscar el producto en el almacén
        val productoEncontrado = tienda.almacen.find { it?.id == id }

        if (productoEncontrado != null) {
            cliente.agregarProductoCarrito(productoEncontrado)
        } else {
            println("No se encontró el producto en el almacén.")
        }
    }

    private fun buscarPorCategoria() {
        println("=== BUSCAR PRODUCTOS POR CATEGORÍA ===")
        Categoria.values().forEachIndexed { index, cat -> println("${index + 1}. $cat") }
        val catIndex = readln().toIntOrNull() ?: 4
        val categoria = Categoria.values().getOrNull(catIndex - 1) ?: Categoria.Generica

        tienda.buscarProductosCategoria(categoria)
    }

    private fun leerId(mensaje: String): Int {
        println("Introduce el id del $mensaje:")
        return readln().toIntOrNull() ?: 0
    }
}
