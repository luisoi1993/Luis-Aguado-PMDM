package com.example.vuelos.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vuelos.R
import com.example.vuelos.adapter.AdapterVuelo
import com.example.vuelos.databinding.ActivityHomeBinding
import com.example.vuelos.dataset.Dataset
import com.example.vuelos.model.Vuelo

class HomeActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityHomeBinding

    private lateinit var adapterVuelo: AdapterVuelo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        acciones()
        initGUI()
    }

    private fun initGUI() {
        adapterVuelo = AdapterVuelo(Dataset.listaVuelos, this)

        binding.recyclerViewVuelos.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        binding.recyclerViewVuelos.adapter = adapterVuelo
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_principal, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
           R.id.menu_item_favoritos -> {
                val intent = Intent(this, FavoritoActivity::class.java)
                startActivity(intent)
            }
            R.id.menu_item_salir -> {
                finish()
            }
        }
        return true;
    }
    private fun acciones() {
        binding.buttonVuelo.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if (p0 == binding.buttonVuelo) {

            val origen = binding.spinnerOrigen.selectedItem.toString()
            val destino = binding.spinnerDestino.selectedItem.toString()
            val fecha = "12/12/2025"
            val hora = "12:00"
            val precio = 100.0
            val asientos = 10

            val vuelo = Vuelo(origen, destino, fecha, hora, precio, asientos)

            // 1️⃣ Añadir al dataset
            Dataset.agregarVuelo(vuelo)

            // 2️⃣ Avisar al adapter
            adapterVuelo.notifyItemInserted(Dataset.listaVuelos.size - 1)
        }
    }

}