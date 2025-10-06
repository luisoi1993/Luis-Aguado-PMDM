/*Implementa una función memoize para funciones (T) -> R que cachee resultados según el argumento.
Demuestra su uso con una función costosa como fibonacci y mide mejoras con System.nanoTime.*/



fun main() {

    // --- Función Fibonacci normal (sin memoización) ---
    fun fibonacciNormal(n: Int): Long {
        return if (n <= 1) n.toLong() else fibonacciNormal(n - 1) + fibonacciNormal(n - 2)
    }

    // --- Función memoize genérica ---
    fun <T, R> memoize(func: (T) -> R): (T) -> R {
        val cache = mutableMapOf<T, R>() // almacena resultados ya calculados
        return { arg: T ->
            cache.getOrPut(arg) { func(arg) } // si existe lo devuelve, si no lo calcula y guarda
        }
    }

    // --- Fibonacci memoizado ---
    // Usamos una variable 'lateinit' para poder referenciarse dentro de sí misma
    lateinit var fibonacciMemo: (Int) -> Long

    fibonacciMemo = memoize { n: Int ->
        if (n <= 1) n.toLong() else fibonacciMemo(n - 1) + fibonacciMemo(n - 2)
    }

    // --- Medición de tiempos ---
    val n = 40

    val tiempoNormalInicio = System.nanoTime()
    val resultadoNormal = fibonacciNormal(n)
    val tiempoNormalFin = System.nanoTime()

    val tiempoMemoInicio = System.nanoTime()
    val resultadoMemo = fibonacciMemo(n)
    val tiempoMemoFin = System.nanoTime()

    // --- Resultados ---
    println("Fibonacci normal($n) = $resultadoNormal")
    println("Tiempo normal: ${(tiempoNormalFin - tiempoNormalInicio) / 1_000_000} ms")

    println("Fibonacci memo($n) = $resultadoMemo")
    println("Tiempo memoizado: ${(tiempoMemoFin - tiempoMemoInicio) / 1_000_000} ms")
}
