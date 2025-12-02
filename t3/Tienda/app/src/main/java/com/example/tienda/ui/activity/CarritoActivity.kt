package com.example.tienda.ui.activity

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tienda.R
import com.example.tienda.adapter.AdapterProducto
import com.example.tienda.databinding.ActivityCarritoBinding
import com.example.tienda.dataset.DataSet
import com.google.android.material.snackbar.Snackbar

class CarritoActivity : AppCompatActivity(), View.OnClickListener {

    private  lateinit var adapterProducto: AdapterProducto
    private lateinit var binding: ActivityCarritoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarritoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        acciones()
        instancias()
        initGUI()
    }

    private fun initGUI() {
        ponerRecycler(adapterProducto)
        val total = DataSet.total.toString()
        val textoTotal = "Total: $total"
        binding.textViewTotal.text = textoTotal
    }

    private fun acciones() {
        binding.buttonComprar.setOnClickListener(this)
    }
    private fun instancias() {
        val listaCarrito = DataSet.listaCarrito
        adapterProducto = AdapterProducto(listaCarrito, this){

        }



    }

    private fun ponerRecycler(adapter: AdapterProducto) {

        if (resources.configuration.orientation == 1) { // Vertical
            binding.recyclerProductos.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        } else { // Horizontal
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
            binding.textViewTotal.text = "Total: 0.0"
            val snackbar = Snackbar.make(binding.root, "Compra realizada", Snackbar.LENGTH_INDEFINITE)
            snackbar.setAction("Aceptar"){
                finish()
            }
            snackbar.show()


        }
    }


}