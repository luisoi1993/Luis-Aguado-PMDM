/*Escribe una función inline reified T que convierta un Any a T? de forma segura usando when y reflexión mínima, y añade pruebas rápidas.*/

inline fun <reified T> Any?.safeCast(): T? {
    if (this == null) return null

    // ayuda para conversiones numéricas
    fun Number.toT(): T? {
        @Suppress("UNCHECKED_CAST")
        return when (T::class) {
            Int::class -> this.toInt() as T
            Long::class -> this.toLong() as T
            Double::class -> this.toDouble() as T
            Float::class -> this.toFloat() as T
            Short::class -> this.toShort() as T
            Byte::class -> this.toByte() as T
            else -> null
        }
    }

    // Primero casos específicos por T
    return when {
        // Números: si la instancia es Number convierto; si es String intento parse
        T::class == Int::class -> when (this) {
            is Number -> this.toT()
            is String -> this.toIntOrNull() as T?
            else -> null
        }
        T::class == Long::class -> when (this) {
            is Number -> this.toT()
            is String -> this.toLongOrNull() as T?
            else -> null
        }
        T::class == Double::class -> when (this) {
            is Number -> this.toT()
            is String -> this.toDoubleOrNull() as T?
            else -> null
        }
        T::class == Float::class -> when (this) {
            is Number -> this.toT()
            is String -> this.toFloatOrNull() as T?
            else -> null
        }
        T::class == Short::class -> when (this) {
            is Number -> this.toT()
            is String -> this.toShortOrNull() as T?
            else -> null
        }
        T::class == Byte::class -> when (this) {
            is Number -> this.toT()
            is String -> this.toByteOrNull() as T?
            else -> null
        }

        // Boolean: acepta Boolean directamente o Strings "true"/"false"
        T::class == Boolean::class -> when (this) {
            is Boolean -> this as T
            is String -> when (this.trim().lowercase()) {
                "true", "1", "si", "sí", "y", "yes" -> true as T
                "false", "0", "no", "n" -> false as T
                else -> null
            }
            is Number -> when (this.toInt()) { 0 -> false as T; 1 -> true as T; else -> null }
            else -> null
        }

        // String: todo se puede convertir a String razonablemente
        T::class == String::class -> this.toString() as T

        // Colecciones: List y Map (sin checks de tipo genérico porque se pierden en runtime)
        T::class == List::class || T::class == MutableList::class -> if (this is List<*>) this as T else null
        T::class == Map::class || T::class == MutableMap::class -> if (this is Map<*, *>) this as T else null
        T::class == Set::class || T::class == MutableSet::class -> if (this is Set<*>) this as T else null

        // Si T es superclase/interface del tipo actual, hacemos cast directo
        else -> {
            // Comprobación runtime mínima con reflection
            val target = T::class.java
            if (target.isAssignableFrom(this::class.java)) {
                @Suppress("UNCHECKED_CAST")
                (this as T)
            } else {
                null
            }
        }
    }
}

// --------------------------
// Tests rápidos
// --------------------------
fun main() {
    val n: Any = 42
    val s: Any = "123"
    val d: Any = 3.14
    val bTrue: Any = "true"
    val list: Any = listOf(1, 2, 3)
    val map: Any = mapOf("a" to 1)

    println(n.safeCast<Int>())        // 42
    println(n.safeCast<Long>())       // 42
    println(n.safeCast<String>())     // "42"
    println(s.safeCast<Int>())        // 123
    println(s.safeCast<Double>())     // 123.0
    println(d.safeCast<Int>())        // 3 (de Double a Int)
    println("notANumber".safeCast<Int>()) // null
    println(bTrue.safeCast<Boolean>())    // true
    println(1.safeCast<Boolean>())        // true (1 -> true)
    println(0.safeCast<Boolean>())        // false
    println(list.safeCast<List<Int>>())   // [1, 2, 3]
    println(map.safeCast<Map<String, Int>>()) // {a=1}

    // Ejemplo de objetos:
    open class Animal(val name: String)
    class Perro(name: String, val raza: String) : Animal(name)

    val perro: Any = Perro("Fido", "Labrador")
    println(perro.safeCast<Animal>()?.name) // "Fido"
    println(perro.safeCast<Perro>()?.raza)  // "Labrador"
    println(perro.safeCast<String>())       // "Perro@..." (toString) porque String acepta any.toString()

    // Ejemplo nulo
    val nada: Any? = null
    println(nada.safeCast<String>()) // null
}
