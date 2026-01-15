package com.example.agendajson.dataset


import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.agendajson.model.User


class DataSet {

    companion object {

        val lista: ArrayList<User> = arrayListOf()
        val listaFiltrada: ArrayList<User> = arrayListOf()
        private var cargado = false

        fun cargarProductos(context: Context, onFinish: () -> Unit) {

            // 🔒 Si ya está cargado, no volvemos a llamar a Volley
            if (cargado) {
                onFinish()
                return
            }

            val url = "https://dummyjson.com/users"
            val queue = Volley.newRequestQueue(context)

            val request = JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                { response ->

                    lista.clear()
                    listaFiltrada.clear()

                    val productosArray = response.getJSONArray("users")

                    for (i in 0 until productosArray.length()) {
                        val obj = productosArray.getJSONObject(i)

                        val usuario = User(
                            id = obj.getLong("id"),
                            firstName = obj.getString("firstName"),
                            lastName = obj.getString("lastName"),
                            maidenName = obj.getString("maidenName"),
                            age = obj.getLong("age"),
                            gender = obj.getString("gender"),
                            email = obj.getString("email"),
                            image = obj.getString("image")
                        )

                        lista.add(usuario)
                        listaFiltrada.add(usuario)
                    }

                    cargado = true
                    Log.d("DATASET", "Usuarios cargados: ${lista.size}")
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
