package model

interface Descargable {
    var tamanioGB : Double
    fun calcularTiempoDescarga(velocidadInternet: Double): Double
    fun obtenerTamanioGB() : Double


}