package model

class Tienda(var nombre : String) {
    lateinit var almacen: Array<Producto?>
    var caja: Double = 0.0

    // init -> ejecuta si o si despues del constructor (primario o secundario)
    init {
        almacen = arrayOfNulls(6)
    }

/*
    fun mostrarDatos(){
        var nulos = false

        println("El nombre es: $nombre")
        for (producto in almacen){
            if (producto == null) {
                nulos = true
            }
            println("El producto es : $producto" )
        }
        if (nulos){
            println("Todos los productos son nulos.")
        }
        println("La caja tiene este dinero: $caja")
    }
    */

    fun mostrarAlmacen(){
        var nulos = 0
        almacen.forEach {
            it?.mostrarDatos() ?: nulos++
        }
        if(nulos== almacen.size) println("No hay productos en el almacen")
    }

    fun agregarProducto(producto: Producto) {
        for (item in 0..almacen.size-1){
            if(almacen[item] == null){
               almacen[item] = producto
                return
            }
        }
        println("El almacen esta completo")
    }

    fun venderProducto(id : Int){
        for (i in 0..almacen.size-1){
                // no es nulo lo que accedo
            if(almacen[i]!= null &&  almacen[i]?.id == id ){
                caja += almacen[i]!!.precio
                almacen[i] == null
                return
            }
        }
        println("El id indicado no esta en la lista")
    }

    fun buscarProductoCategoria(categoria: Categoria){
        // filtrado -> obteniendo varios
       val filtro: List<Producto?>  = almacen.filter {
            return@filter it?.categoria == categoria
        } as ArrayList<Producto?>

        println("EL numero de elementos resultantes es ${filtro.size}")
    }

    fun mostrarProductosCategoria(categoria : Categoria){
        // filtrando -> obteniendo varios
    }

    fun buscarProductoId(id: Int):Unit{
        // buscando -> obtengo solo un elemento
        var productoBusqueda: Producto? = almacen.find {
            return@find it?.id == id
        }
    }



}

/*//Vamos a crear una tienda ara ello crear la clase necesaria donde se pueda
// asignar 1- Nombre a la tienda(obligatorio)
// 2- Almacen : sitio donde se guardan los productos tiene un tamaño fijo de 6
// 3- caja aqui se guardara la pasta cuand se venda un producto*/

/*Un metodo para poder mostrar todos los productos del almacen
* en caso de tener todos los huecos disponibles es decir vacios mostrar un aviso*/
/*aGREGAR UN ELEMENTO AL ALMACEN en caso de no tener hueco disponoble se mostrara un aviso*/
/*Vamos a vender un producto para ello se solicita el id del producto a vender en caso de estar en el almacen
* se elimina de este su precio se suma a la caja si se vende se da aviso de producto vendido y se da el valor de la caja
* si no se encuenra se da aviso de que no esta en el almacen*/