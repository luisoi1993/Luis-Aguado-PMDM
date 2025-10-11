package model

class Tienda(
    var nombre: String,
) {

    var caja: Double = 0.0
    lateinit var almacen: Array<Producto?>

    // init -> ejecuta si o si despues del constructor (primario o secundario)
    init {
        almacen = arrayOfNulls(6)
    }

    fun mostrarAlmacen() {
        var nulos = 0;
        almacen.forEach {
            it?.mostrarDatos() ?: nulos++ /*if (it == null){
                nulos++
            }*/
        }
        if (nulos == almacen.size)
            println("No hay productos en el almacen")
    }


    // agregar un elemento al almacen. En caso de no tener hueco
    // disponible se mostrara un aviso
    fun agregarProducto(producto: Producto): Boolean {
        for (i in 0 until almacen.size) {
            if (almacen[i] == null) {
                almacen[i] = producto
                return true
            }
        }
        println("El almacen esta completo")
        return false
    }

    // vamos a vender un producto. PAra ello se solicita el id del producto
    // a vender. En caso de estar en el almacen:
    // se elimina de este
    // su precio se suma a la caja
    // si se vende se da aviso de producto vendido y se da el valor de la caja
    // si no se encuentra se da aviso de que no esta en el almacen

    fun venderProducto(id: Int){
        for ( i in 0..almacen.size-1 ){
            // no es nulo lo que accedo
            if (almacen[i]!=null && almacen[i]?.id == id){
                caja += almacen[i]!!.precio
                almacen[i] = null
                return
            }
        }
        println("El id indicado no esta en la lista")
    }

    fun buscarProductosCategoria(categoria: Categoria) {
        // Filtra los productos que coincidan con la categoría
        val filtro = almacen.filter { it?.categoria == categoria }

        if (filtro.isEmpty()) {
            println("No se encontraron productos en la categoría ${categoria.name}.")
        } else {
            println("El número de elementos resultantes es ${filtro.size}")
            println("--- Productos en la categoría ${categoria.name.uppercase()} ---")
            filtro.forEach { it?.mostrarDatos() }
        }
    }


    fun buscarProductoId(id: Int) {
        val productoBusqueda = almacen.find { it?.id == id }

        if (productoBusqueda != null) {
            println("Producto encontrado:")
            productoBusqueda.mostrarDatos()
        } else {
            println("No se encontró ningún producto con el ID $id.")
        }
    }

}