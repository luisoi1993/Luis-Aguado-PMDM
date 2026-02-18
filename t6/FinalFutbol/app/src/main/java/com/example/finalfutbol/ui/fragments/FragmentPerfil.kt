package com.example.finalfutbol.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.finalfutbol.databinding.FragmentPerfilBinding
import com.example.finalfutbol.dataset.Dataset
import com.example.finalfutbol.model.User
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class FragmentPerfil: Fragment() {
    private lateinit var binding: FragmentPerfilBinding
    private lateinit var database: FirebaseDatabase

    private lateinit var contraseina: String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPerfilBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onResume() {
        super.onResume()
        database = FirebaseDatabase.getInstance("https://futbol-8e489-default-rtdb.europe-west1.firebasedatabase.app/")
        val uid = Dataset.uidLogeado
        database.reference
            .child("users")
            .child(uid)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val user = snapshot.getValue(User::class.java)

                    if (user != null) {
                        binding.editTextNombre.setText(user.nombre)
                        binding.editTextApellido.setText(user.apellido)
                        binding.editTextTelefono.setText(user.telefono.toString())
                        binding.editTextCorreo.setText(user.correo)
                        binding.editTextDireccion.setText(user.direccion)
                        contraseina = user.contraseña
                    }
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })

            /*
            .addValueEventListener(object : ValueEventListener {

                override fun onDataChange(snapshot: DataSnapshot) {

                    val user = snapshot.getValue(User::class.java)

                    if (user != null) {
                        binding.editTextNombre.setText(user.nombre)
                        binding.editTextApellido.setText(user.apellido)
                        binding.editTextTelefono.setText(user.telefono.toString())
                        binding.editTextCorreo.setText(user.correo)
                        binding.editTextDireccion.setText(user.direccion)
                        contraseina = user.contraseña
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("Firebase", error.message)
                }
            })

             */
        //hacer que pasen cosas en el click del boton cambiar datos
        binding.buttonCambiarDatos.setOnClickListener {
                val nombre = binding.editTextNombre.text.toString()
                val apellido = binding.editTextApellido.text.toString()
                val telefono = binding.editTextTelefono.text.toString().toInt()
                val correo = binding.editTextCorreo.text.toString()
                val direccion = binding.editTextDireccion.text.toString()
                val uid = Dataset.uidLogeado

                Snackbar.make(binding.root, contraseina, Snackbar.LENGTH_SHORT).show()

                val user = User(nombre, apellido, telefono, correo, "", direccion)
                database.reference
                    .child("users")
                    .child(uid)
                    .setValue(user)

            database.reference
                .child("users")
                .child(uid)
                .addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val user = snapshot.getValue(User::class.java)

                        if (user != null) {
                            binding.editTextNombre.setText(user.nombre)
                            binding.editTextApellido.setText(user.apellido)
                            binding.editTextTelefono.setText(user.telefono.toString())
                            binding.editTextCorreo.setText(user.correo)
                            binding.editTextDireccion.setText(user.direccion)
                            contraseina = user.contraseña
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {

                    }

                })


            }

        }



    }


