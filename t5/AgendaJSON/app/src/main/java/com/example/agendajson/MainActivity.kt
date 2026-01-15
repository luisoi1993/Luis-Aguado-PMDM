package com.example.agendajson

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.agendajson.adapter.AdapterUsuario
import com.example.agendajson.databinding.ActivityMainBinding
import com.example.agendajson.dataset.DataSet
import com.example.agendajson.model.User
import com.example.agendajson.ui.dialogs.DialogoFiltrar
import com.google.gson.Gson
import org.json.JSONArray



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: AdapterUsuario

    private val listaCompleta = ArrayList<User>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        realizarPeticionJSON()
        initRecycler()
        cargarUsuariosVolley()

    }

    private fun initRecycler() {
        adapter = AdapterUsuario(arrayListOf(), this)

        binding.recyclerView.layoutManager =
            LinearLayoutManager(this)

        binding.recyclerView.adapter = adapter
    }
    private fun cargarUsuariosVolley() {
        val url = "https://dummyjson.com/users"

        val request = JsonObjectRequest(url,
            { response ->
                val usersArray = response.getJSONArray("users")
                val gson = Gson()

                listaCompleta.clear()

                for (i in 0 until usersArray.length()) {
                    val userJSON = usersArray.getJSONObject(i)
                    val user = gson.fromJson(userJSON.toString(), User::class.java)
                    listaCompleta.add(user)
                }

                // 🔥 PASAMOS DATOS AL ADAPTER
                adapter.setDatos(listaCompleta)
            },
            { error ->
                Log.e("VOLLEY", error.toString())
            }
        )

        Volley.newRequestQueue(this).add(request)
    }



    private fun realizarPeticionJSON() {
        val url = "https://dummyjson.com/users"
        // 1 Realizar la peticion de forma correcta
        val peticionJSON: JsonObjectRequest = JsonObjectRequest(url,{
            val usersArray: JSONArray =  it.getJSONArray("users")
            for (i in 0 until usersArray.length()){
                val gson = Gson()
                val userJSON = usersArray.getJSONObject(i)
                val user: User = gson.fromJson(userJSON.toString(),User::class.java)
                Log.v("Conexion","el nombre del usuarioes ${user.firstName}")
            }
           // Log.v("Conexion",it.toString())
            },
            {
                Log.v("Conexion","Los datos no se obtienen de forma incorrecta")})
        //2. Añado la peticin a la pila de Volley

        Volley.newRequestQueue(this).add(peticionJSON)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menuFiltrar -> {
                val dialogoFiltrar = DialogoFiltrar()
                dialogoFiltrar.show(supportFragmentManager,"DialogoFiltrar")
            }
        }
        return true
    }
}