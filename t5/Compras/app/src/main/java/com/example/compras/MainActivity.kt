package com.example.compras

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.DEFAULT_ARGS_KEY
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.compras.adapter.AdepterProducto
import com.example.compras.databinding.ActivityMainBinding
import com.example.compras.dataset.DataSet
import com.example.compras.ui.dialogs.DialogoFiltrar

class MainActivity : AppCompatActivity(), DialogoFiltrar.OnDialogoFiltrarListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: AdepterProducto


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        initRecycler()
        cargarDatos()
        acciones()

    }

    private fun acciones() {
        binding.textViewContador.text = DataSet.contador.toString()

    }

    private fun initRecycler() {
        adapter = AdepterProducto(DataSet.listaFiltrada, this)

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
                val dialogoFiltrar = DialogoFiltrar()
                dialogoFiltrar.show(supportFragmentManager, "dialogo")
            }
            R.id.menu_buscar -> {
                // Handle buscar action
            }
            R.id.menu_resetar -> {
                DataSet.listaFiltrada.clear()
                DataSet.listaFiltrada.addAll(DataSet.lista)
                adapter.notifyDataSetChanged()
            }
            }

        return true
    }

    override fun onDialogoFiltrar(categorias: Array<String>) {
        DataSet.listaFiltrada.clear()

        val resultado = DataSet.lista.filter { producto ->
            categorias.any { categoria ->
                producto.categoria.equals(categoria, ignoreCase = true)
            }
        }

        adapter.lista.clear()
        adapter.lista.addAll(resultado)
        adapter.notifyDataSetChanged()
    }
}