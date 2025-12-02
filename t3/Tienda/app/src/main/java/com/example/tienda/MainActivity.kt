package com.example.tienda

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tienda.adapter.AdapterProducto
import com.example.tienda.databinding.ActivityMainBinding
import com.example.tienda.dataset.DataSet
import com.example.tienda.model.Producto
import com.example.tienda.ui.activity.CarritoActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterProducto: AdapterProducto


    private lateinit var lista: ArrayList<Producto>
    private lateinit var listaMuebles: ArrayList<Producto>
    private lateinit var listaTecnologia: ArrayList<Producto>
    private lateinit var listaRopa: ArrayList<Producto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancias()
        initGUI()
        acciones()
    }

    override fun onResume() {
        super.onResume()
        binding.textViewCarritoContador.text = DataSet.contador.toString()
    }



    private fun instancias() {


        lista = DataSet.lista
        listaMuebles = DataSet.getListaFiltrada("muebles") as ArrayList<Producto>
        listaTecnologia = DataSet.getListaFiltrada("tecnologia") as ArrayList<Producto>
        listaRopa = DataSet.getListaFiltrada("ropa") as ArrayList<Producto>


        adapterProducto = AdapterProducto(lista, this){
            binding.textViewCarritoContador.text = DataSet.contador.toString()
        }

    }


    private fun initGUI() {

        ponerRecycler(adapterProducto)

    }


    private fun acciones() {

        binding.buttonCarrito.setOnClickListener(this)

        binding.spinnerCategorias.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val seleccion = binding.spinnerCategorias.selectedItem.toString()


                    adapterProducto = when (seleccion) {
                        "Mueble" -> AdapterProducto(listaMuebles, this@MainActivity) {
                            binding.textViewCarritoContador.text = DataSet.contador.toString()
                        }
                        "Tecnologia" -> AdapterProducto(listaTecnologia, this@MainActivity) {
                            binding.textViewCarritoContador.text = DataSet.contador.toString()
                        }
                        "Ropa" -> AdapterProducto(listaRopa, this@MainActivity) {
                            binding.textViewCarritoContador.text = DataSet.contador.toString()
                        }
                        "Todos" -> AdapterProducto(lista, this@MainActivity) {
                            binding.textViewCarritoContador.text = DataSet.contador.toString()
                        }
                        else -> AdapterProducto(lista, this@MainActivity) {
                            binding.textViewCarritoContador.text = DataSet.contador.toString()
                        }
                    }



                    ponerRecycler(adapterProducto)
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
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
        if (p0 == binding.buttonCarrito) {
            val intent = Intent(this, CarritoActivity::class.java)
            startActivity(intent)
        }
    }
}
