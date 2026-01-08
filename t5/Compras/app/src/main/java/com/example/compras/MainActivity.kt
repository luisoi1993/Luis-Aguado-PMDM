package com.example.compras

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.compras.adapter.AdepterProducto
import com.example.compras.databinding.ActivityMainBinding
import com.example.compras.dataset.DataSet

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: AdepterProducto


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        initRecycler()
        cargarDatos()

    }

    private fun initRecycler() {
        adapter = AdepterProducto(DataSet.lista, this)

        binding.recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        binding.recyclerView.adapter = adapter
    }
    private fun cargarDatos() {
       DataSet.cargarProductos(this) {
            adapter.notifyDataSetChanged()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       when (item.itemId) {
            R.id.menu_filtrar -> {
                // Handle filtrar action
            }
            R.id.menu_buscar -> {
                // Handle buscar action
            }
            R.id.menu_resetar -> {
                // Handle resetar action
            }
            }

        return true
    }
}