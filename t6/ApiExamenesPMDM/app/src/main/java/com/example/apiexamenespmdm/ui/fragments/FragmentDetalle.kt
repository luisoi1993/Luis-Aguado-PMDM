package com.example.apiexamenespmdm.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.apiexamenespmdm.databinding.FragmentDetalleBinding
import com.example.apiexamenespmdm.model.Examen

class FragmentDetalle: Fragment() {

    private lateinit var examen: Examen
    private lateinit var binding: FragmentDetalleBinding
    override fun onAttach(context: Context) {
        super.onAttach(context)
        val bundle = arguments
        if (bundle != null) {
             examen = bundle.getSerializable("examen") as Examen



        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalleBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onResume() {
        super.onResume()
        binding.textViewTitulo.text = examen.titulo
        binding.textViewCategoria.text = examen.dificultad
        binding.textViewDetalle.text = examen.detalle
    }


}