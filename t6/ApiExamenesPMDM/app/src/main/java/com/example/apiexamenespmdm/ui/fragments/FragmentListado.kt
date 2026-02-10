package com.example.apiexamenespmdm.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.apiexamenespmdm.databinding.FragmentListadoBinding
import com.example.apiexamenespmdm.model.Examen
import com.google.firebase.database.FirebaseDatabase

class FragmentListado: Fragment() {
    private lateinit var binding: FragmentListadoBinding

    // private lateinit var adapter: ExamenAdapter
    private lateinit var database: FirebaseDatabase

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListadoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        database = FirebaseDatabase.getInstance()
        val ref = database.reference.child("examenes")

        ref.get().addOnSuccessListener { snapshot ->
            if (snapshot.exists()) {
                val lista = mutableListOf<Examen>()

                for (child in snapshot.children) {
                    val examen = child.getValue(Examen::class.java)
                    if (examen != null) {
                        lista.add(examen)
                    }
                }
            }
        }
    }

}