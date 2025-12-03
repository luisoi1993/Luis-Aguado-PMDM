package com.example.tiendados.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tiendados.R
import com.example.tiendados.adapter.AdapterProducto
import com.example.tiendados.databinding.ActivityCarritoBinding
import com.example.tiendados.dataset.DataSet
import com.google.android.material.snackbar.Snackbar

class CarritoActivity : AppCompatActivity(), View.OnClickListener,
    AdapterProducto.OnProductoCarritoListener {

    private lateinit var binding: ActivityCarritoBinding
    private lateinit var adapterProducto: AdapterProducto

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarritoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancias()
        initGUI()
        acciones()
    }

    private fun instancias() {
        val listaCarrito = DataSet.listaCarrito
        adapterProducto = AdapterProducto(listaCarrito, this)
    }

    private fun initGUI() {
        binding.textViewTotal.text = "Total: ${DataSet.total} €"
        ponerRecycler(adapterProducto)
    }


    private fun acciones() {
        binding.buttonComprar.setOnClickListener(this)
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
        if (p0 == binding.buttonComprar) {

            DataSet.total = 0.0
            DataSet.contador = 0
            DataSet.listaCarrito.clear()

            binding.textViewTotal.text = "Total: 0.0 €"

            Snackbar.make(binding.root, "Compra realizada", Snackbar.LENGTH_INDEFINITE)
                .setAction("Aceptar") {
                    finish()
                }.show()
        }
    }


    // Para cumplir la interfaz, aunque aquí no la usamos
    override fun actualizarContadorCarrito() { }
}
