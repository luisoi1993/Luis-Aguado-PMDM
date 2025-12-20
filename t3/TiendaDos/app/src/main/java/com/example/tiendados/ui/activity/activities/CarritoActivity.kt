package com.example.tiendados.ui.activity.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tiendados.R
import com.example.tiendados.adapter.AdapterProducto
import com.example.tiendados.adapter.AdapterProductoDos
import com.example.tiendados.databinding.ActivityCarritoBinding
import com.example.tiendados.dataset.DataSet
import com.example.tiendados.ui.activity.dialogs.DialogoCompra
import com.google.android.material.snackbar.Snackbar


class CarritoActivity : AppCompatActivity(),
    View.OnClickListener,
    AdapterProductoDos.OnProductoCarritoListener,
    DialogoCompra.OnDialogoCompraListener{

    private lateinit var binding: ActivityCarritoBinding
    private lateinit var adapterProducto: AdapterProductoDos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarritoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarCarrito)


        instancias()
        initGUI()
        acciones()
    }

    private fun instancias() {
        val listaCarrito = DataSet.listaCarrito
        adapterProducto = AdapterProductoDos(listaCarrito, this)  // ← ahora funciona
    }

    private fun initGUI() {
       // binding.textViewTotal.text = "Total: ${DataSet.total} €"
        ponerRecycler(adapterProducto)
    }

    private fun acciones() {
     //   binding.buttonComprar.setOnClickListener(this)
    }

    private fun ponerRecycler(adapter: AdapterProductoDos) { // ← también corregido
        if (resources.configuration.orientation == 1) {
            binding.recyclerProductos.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        } else {
            binding.recyclerProductos.layoutManager =
                GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        }

        binding.recyclerProductos.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_carrito, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.menuPagar -> {
                val dialogoConfirmacionCompra = DialogoCompra()
                dialogoConfirmacionCompra.show(supportFragmentManager, null)
            }
        }
        return true
    }

    override fun onClick(p0: View?) {
        /*
        if (p0 == binding.buttonComprar) {

            DataSet.total = 0.0
            DataSet.contador = 0
            DataSet.listaCarrito.clear()

            binding.textViewTotal.text = "Total: 0.0 €"

            Snackbar.make(binding.root, "Compra realizada", Snackbar.LENGTH_INDEFINITE)
                .setAction("Aceptar") {
                    finish()
                }.show()
        } */
    }

    override fun actualizarContadorCarrito() { }

    override fun onDialogoCompra() {
        DataSet.total = 0.0
        DataSet.contador = 0
        DataSet.listaCarrito.clear()

        adapterProducto.limpiarLista()

        Snackbar.make(
            binding.root, "Compra realizada correctamente",
            Snackbar.LENGTH_SHORT
        ).show()
    }
}
