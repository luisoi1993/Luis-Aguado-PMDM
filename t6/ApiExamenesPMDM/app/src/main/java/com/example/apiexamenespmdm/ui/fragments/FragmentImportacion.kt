package com.example.apiexamenespmdm.ui.fragments


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment

import androidx.navigation.fragment.findNavController
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.apiexamenespmdm.R
import com.example.apiexamenespmdm.databinding.FragmentImportacionBinding
import com.example.apiexamenespmdm.model.Examen
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.gson.Gson


class FragmentImportacion: Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentImportacionBinding
    private lateinit var database: FirebaseDatabase


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentImportacionBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onResume() {
        super.onResume()
        binding.buttonImportar.setOnClickListener(this)
        database = FirebaseDatabase.getInstance()
    }

    override fun onClick(p0: View?) {

        if (p0 == binding.buttonImportar) {

            val ref = database.reference.child("examenes")

            // 1️⃣ Primero comprobar si ya hay datos
            ref.get().addOnSuccessListener { snapshot ->

                if (snapshot.exists()) {
                    // YA EXISTEN → ir directo al listado
                    findNavController().navigate(
                        R.id.action_fragmentImportacion_to_fragmentListado
                    )

                } else {
                    // NO EXISTEN → importar desde API
                    importarDesdeApi(ref)
                }
            }
        }
    }

    private fun importarDesdeApi(ref: DatabaseReference) {

        val urlConsulta = "https://698949d3c04d974bc69ed0b0.mockapi.io/api/v1/examenes"
        val gson = Gson()

        val peticion = JsonArrayRequest(urlConsulta,
            { response ->

                for (i in 0 until response.length()) {

                    val obj = response.getJSONObject(i)

                    val examen: Examen =
                        gson.fromJson(obj.toString(), Examen::class.java)

                    ref.child(examen.id).setValue(examen)
                }

                // 2️⃣ Cuando termina → navegar
                findNavController().navigate(
                    R.id.action_fragmentImportacion_to_fragmentListado
                )
            },
            {
                Log.e("API", it.toString())
            }
        )

        Volley.newRequestQueue(requireContext()).add(peticion)
    }

}