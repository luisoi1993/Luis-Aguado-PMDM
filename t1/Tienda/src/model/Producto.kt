package model

class Producto(var id: Int, var precio : Double = 10.0, var categoria: Categoria = Categoria.Generica, var nombre: String? = null, var descripcion: String? = null) {

    // id
    // precio
    /*
    var nombre: String? = null
    var descripcion : String? = null

    constructor(id: Int, precio: Double, nombre : String) : this(id,precio){
        this.nombre = nombre
    }
    // crear constructor solo con nombre , solo con descripcion
    // y otro con nombre y descripcion
    constructor(id: Int, precio: Double, descripcion: String?) : this(id,precio){
        this.descripcion = descripcion
    }

    constructor(id: Int, precio: Double, nombre: String, descripcion :String) : this(id,precio){
        this.nombre = nombre
        this.descripcion = descripcion
    }
    */
     //Metodo para poder mostrara todos los datos del producto
    // si no hay nombre aperce sin nombre
    // si no hay descripcion aparece sin descripcion



    fun mostrarDatos(){
        println("ID: $id")
        println("Precio: $precio")
        println("Nombre ${nombre ?: "Sin definir"}")
        println("Categoria ${categoria.name}")
        println("Descripcion ${descripcion ?: "SIN DEFINIR"}")
    }

}