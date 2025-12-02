package com.example.tienda.ui.activity

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.tienda.R
import com.example.tienda.databinding.ActivityDetalleBinding
import com.example.tienda.model.Producto
import java.io.Serializable



class DetalleActivity : AppCompatActivity() , View.OnClickListener {
    private lateinit var binding: ActivityDetalleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        acciones()
    }

    private fun acciones() {
        val intent = intent
        val producto = intent.getSerializableExtra("producto") as Producto

        val id = producto.id.toString()
        val nombre = producto.nombre
        val descripcion = producto.descripcion
        val precio = producto.precio.toString()
        val stock = producto.stock.toString()
        val categoria = producto.categoria
        val imagen = producto.imagen



        binding.textViewId.text = id
        binding.textViewNombre.text = nombre
        binding.textViewDescripcion.text = descripcion
        binding.textViewPrecio.text = precio
        binding.textViewStock.text = stock
        binding.textViewCategoria.text = categoria
        Glide.with(this).load(imagen).placeholder(R.drawable.producto).into(binding.imageViewImagen)




        binding.buttonVolver.setOnClickListener(this)



    }

    override fun onClick(p0: View?) {
        if (p0 == binding.buttonVolver) {
            val intent = intent
            finish()
        }
    }

    }
