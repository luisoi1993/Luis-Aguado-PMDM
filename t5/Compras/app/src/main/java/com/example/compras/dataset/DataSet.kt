package com.example.compras.dataset

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.compras.model.Producto

class DataSet {

    companion object {

        val lista: ArrayList<Producto> = arrayListOf()
        private var cargado = false

        fun cargarProductos(context: Context, onFinish: () -> Unit) {

            // 🔒 Si ya está cargado, no volvemos a llamar a Volley
            if (cargado) {
                onFinish()
                return
            }

            val url = "https://dummyjson.com/products"
            val queue = Volley.newRequestQueue(context)

            val request = JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                { response ->

                    lista.clear()

                    val productosArray = response.getJSONArray("products")

                    for (i in 0 until productosArray.length()) {
                        val obj = productosArray.getJSONObject(i)

                        val producto = Producto(
                            imagen = obj.getString("thumbnail"),
                            nombre = obj.getString("title"),
                            precio = obj.getDouble("price"),
                            categoria = obj.getString("category"),
                            stock = obj.getInt("stock"),
                            descripcion = obj.getString("description")
                        )

                        lista.add(producto)
                    }

                    cargado = true
                    Log.d("DATASET", "Productos cargados: ${lista.size}")
                    onFinish()
                },
                { error ->
                    Log.e("DATASET", "Error Volley: ${error.message}")
                    onFinish()
                }
            )

            queue.add(request)
        }
    }
}
