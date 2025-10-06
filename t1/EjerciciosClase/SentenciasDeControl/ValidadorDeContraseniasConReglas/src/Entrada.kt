/*Escribe una función que, dado un String contraseña, aplique
 reglas: longitud mínima, al menos 1 mayúscula, 1 minúscula,
 1 dígito y 1 símbolo. Usa if/when y devuelve un sealed class
 Resultado { Valida | Invalida(errores: List<String>) } con todas las causas.*/

fun main() {
    val contrasenas = listOf(
        "abc",
        "abcdefghi",
        "Abcdefghi",
        "Abc12345",
        "Abc123$%"
    )

    contrasenas.forEach {
        when (val resultado = validarContrasena(it)) {
            is Resultado.Valida -> println("Si \"$it\"es válida")
            is Resultado.Invalida -> {
                println("no\"$it\" inválida: ")
                resultado.errores.forEach { error -> println("   - $error")}
            }
        }
        println()
    }
}

sealed class Resultado {
    object Valida : Resultado()
    data class Invalida(val errores: List<String>) : Resultado()
}

fun validarContrasena(contrasena: String) : Resultado {
    val errores = mutableListOf<String>()

    // Longitud mínima
    if(contrasena.length < 8){
        errores.add("Debe tener al menos 8 caracteres")
    }

    // Mayúscula
    if(!contrasena.any {it.isUpperCase()}) {
        errores.add("Debe tener al menos una letra mayúscula")
    }

    // Minúscula
    if(!contrasena.any{it.isLowerCase()}){
        errores.add("Debe tener al menos una letra minúscula")
    }

    // Dígito
    if (!contrasena.any {!it.isLetterOrDigit()}) {
        errores.add("Debe tener al menos un símbolo")
    }

    return if (errores.isEmpty()) Resultado.Valida else Resultado.Invalida(errores)
}