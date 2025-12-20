package com.example.tiendados

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tiendados.adapter.AdapterProducto
import com.example.tiendados.databinding.ActivityMainBinding
import com.example.tiendados.dataset.DataSet
import com.example.tiendados.model.Producto
import com.example.tiendados.ui.activity.activities.CarritoActivity
import com.example.tiendados.ui.activity.dialogs.DialogoComparacion
import com.example.tiendados.ui.activity.dialogs.DialogoComparar
import com.example.tiendados.ui.activity.dialogs.DialogoInformacion
import com.example.tiendados.ui.activity.dialogs.DialogoResultado
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity(),
    View.OnClickListener,
    AdapterProducto.OnProductoCarritoListener, DialogoComparar.OnCompararListener {

    private var producto1: Producto? = null
    private var producto2: Producto? = null
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterProducto: AdapterProducto

    private lateinit var lista: ArrayList<Producto>
    private lateinit var listaMuebles: ArrayList<Producto>
    private lateinit var listaTecnologia: ArrayList<Producto>
    private lateinit var listaRopa: ArrayList<Producto>

    private var seleccion: Any = "Todos"




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        instancias()
        initGUI()
        acciones()
    }

    override fun onRestart() {
        super.onRestart()
        binding.textViewCarritoContador.text = DataSet.listaCarrito.size.toString()
    }

    private fun instancias() {
        lista = DataSet.lista
        listaMuebles = DataSet.getListaFiltrada("muebles") as ArrayList<Producto>
        listaTecnologia = DataSet.getListaFiltrada("tecnologia") as ArrayList<Producto>
        listaRopa = DataSet.getListaFiltrada("ropa") as ArrayList<Producto>

        adapterProducto = AdapterProducto(lista, this)
    }

    private fun initGUI() {
        ponerRecycler(adapterProducto)
    }

    private fun acciones() {
        binding.buttonCarrito.setOnClickListener(this)

        binding.spinnerCategorias.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                     seleccion = parent!!.adapter.getItem(position)


                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.verCarrito -> {
                // OPCIÓN 1: abrir CarritoActivity
                val intent = Intent(this, CarritoActivity::class.java)
                startActivity(intent)
            }

            R.id.filtrarMuebles -> {
                // OPCIÓN 2: filtrar la lista ( solo muebles)
                /*
                adapterProducto = AdapterProducto(listaMuebles, this)
                ponerRecycler(adapterProducto)
                */

                adapterProducto = when (seleccion) {
                    "Mueble" -> AdapterProducto(listaMuebles, this@MainActivity)
                    "Tecnologia" -> AdapterProducto(listaTecnologia, this@MainActivity)
                    "Ropa" -> AdapterProducto(listaRopa, this@MainActivity)
                    "Todos" -> AdapterProducto(lista, this@MainActivity)
                    else -> AdapterProducto(lista, this@MainActivity)
                }

                ponerRecycler(adapterProducto)


            }

            R.id.menuInfo -> {
                val dialogoInformacion: DialogoInformacion = DialogoInformacion()
                dialogoInformacion.show(supportFragmentManager,null)
            }

            R.id.quitarFiltros -> {
                // OPCIÓN 3: volver a mostrar todos los productos
                adapterProducto = AdapterProducto(lista, this)
                ponerRecycler(adapterProducto)
            }

            R.id.menuComparar -> {
                val dialogoComparar: DialogoComparar = DialogoComparar()
                dialogoComparar.show(supportFragmentManager,null)
            }
        }

        return true
    }


    private fun ponerRecycler(adapter: AdapterProducto) {
        if (resources.configuration.orientation == 1) {
            binding.recyclerProductos.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        } else {
            binding.recyclerProductos.layoutManager =
                GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        }
        binding.recyclerProductos.adapter = adapter
    }

    override fun onClick(p0: View?) {
        if (p0 == binding.buttonCarrito) {
            val intent = Intent(this, CarritoActivity::class.java)
            startActivity(intent)
        }
    }


    override fun actualizarContadorCarrito() {
        binding.textViewCarritoContador.text = DataSet.listaCarrito.size.toString()
    }

    override fun compararProducto(producto: Producto) {
        if (producto1 == null) {
            producto1 = producto;
        } else if (producto2 == null) {
            producto2 = producto;
        } else {
            /*producto2 = producto1
            producto1 = producto*/
            Snackbar.make(
                binding.root, "No hay espacio para comprar",
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }

    override fun onCompararSelected(opcion: String?) {

        if (producto1 == null || producto2 == null || opcion == null) {
            Snackbar.make(binding.root, "Selecciona dos productos primero", Snackbar.LENGTH_SHORT).show()
            return
        }

        val dialogo = DialogoComparacion(
            producto1!!,
            producto2!!,
            opcion
        )

        dialogo.show(supportFragmentManager, "DialogoComparacion")
    }

}
