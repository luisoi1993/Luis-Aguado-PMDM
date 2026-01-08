package com.example.vuelos.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vuelos.R
import com.example.vuelos.adapter.AdapterFavorito
import com.example.vuelos.databinding.ActivityFavoritoBinding
import com.example.vuelos.dataset.Dataset

class FavoritoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavoritoBinding
    private lateinit var adapterFavorito: AdapterFavorito


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoritoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initGUI()
    }

    private fun initGUI() {
        Log.d("FAVORITOS", "Tamaño lista: ${Dataset.listaFavoritos.size}")
        adapterFavorito = AdapterFavorito(Dataset.listaFavoritos, this)

        binding.recyclerViewFavoritos.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


        binding.recyclerViewFavoritos.adapter = adapterFavorito


    }
}