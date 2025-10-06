package model

class Cliente(var id: Int,var nombre: String) {
    lateinit var carrito : ArrayList<Producto>
    var factura : Double = 0.0

    init {
        //carrito = ArrayList()
        carrito = arrayListOf()
    }

    fun agregarProductoCarrito(producto: Producto){
        carrito.add(producto)
        println("Producto agregado al carrito correctamente")
    }

    // mostrar todos los elementos del carrito

    fun mostrarCarrito(){
        if(carrito.isEmpty()){
            println("No hay nada en el carrito")
        } else {
            carrito.forEach { it.mostrarDatos() }
        }

    }

    // mostrar el producto que esta en una posicion indicada
    fun accesoPorPosicion(posicion: Int){
        if(posicion > carrito.size-1){
            println("Id fuera de rengo")
        }else {
            carrito[posicion].mostrarDatos()
        }

    }

    // Eliminar un producto del carrito
    // en caso de no estar el id en el carrito -> aviso de que no se encuentra
    // en caso de si estar en el carrito y solo existir uno, lo elimina
    // en caso de si estar en el carrito y existir varios, confirmacion de eliminar 1 o todos

    fun borrarElementos(id: Int) {
        /*
        // Filtramos los productos con ese id
        val productosConId = carrito.filter { it.id == id }
        val cantidad = productosConId.size

        when {
            cantidad == 0 -> {
                println("No hay ningún producto con id $id")
            }
            cantidad == 1 -> {
                carrito.remove(productosConId[0])
                println("Producto con id $id eliminado correctamente")
            }
            cantidad > 1 -> {
                println("Hay $cantidad productos con id $id. ¿Desea eliminar todos? (s/n)")
                val respuesta = readLine()?.trim()?.lowercase()
                if (respuesta == "s") {
                    carrito.removeAll { it.id == id }
                    println("Todos los productos con id $id han sido eliminados")
                } else {
                    println("No se eliminó ningún producto")
                }
            }
        }

         */

        var listarFiltrado = carrito.filter {
            return@filter it.id == id
        }
        if (listarFiltrado.size == 0){
            println("el numero de resultado es ${listarFiltrado.size} por lo que no se puede borrar")
        }
        else if (listarFiltrado.size == 1){
            carrito.remove(listarFiltrado.first())
            println("Borrado correctamente")
        }
        else{
            println("Se han encontrado varias conincidencias : Cual quieres borrar: (1. para el primero/ n. para todos)")
            val opcion : String = readln()
            if (opcion.equals("1", ignoreCase = true)){
                carrito.remove(listarFiltrado.first())
            }else if(opcion.equals("n", ignoreCase = true)){
                carrito.removeAll(listarFiltrado.toSet())
            }

        }

        /*
        * HAcer un metodo para calcular la factura del cliente
        * cuando un cliente pide la factura se muestra la factura y vacia el carrito*/

        fun pedirFactura(){
            if(carrito.isEmpty()){
                println("No puedes pedir, no hay productos en el carrito")
            }else{
                carrito.forEach {
                    factura += it.precio
                }
                println("Debes un total de $factura")
                carrito.clear()
            }
        }

    }

}