package com.example.tiendados.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tiendados.R
import com.example.tiendados.databinding.FragmentRegistroBinding
import com.example.tiendados.model.User
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegistroBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase

    private lateinit var adapterEdad: ArrayAdapter<Int>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentRegistroBinding.inflate(inflater, container, false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configurarSpinner()
        configurarBoton()
    }



    private fun configurarSpinner() {
        val edades = (16..90).toList()

        adapterEdad = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            edades
        )

        adapterEdad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinnerEdadRegistro.adapter = adapterEdad
    }



    private fun configurarBoton() {

        binding.btnRegistro.setOnClickListener {

            val nombre = binding.editNombreRegistro.text.toString()
            val apellido = binding.editApellidoRegistro.text.toString()
            val correo = binding.editCorreoRegistro.text.toString()
            val pass = binding.editPassRegistro.text.toString()
            val edad = binding.spinnerEdadRegistro.selectedItem.toString().toInt()

            if (nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty() || pass.isEmpty()) {
                Snackbar.make(binding.root, "Rellena todos los campos", Snackbar.LENGTH_LONG).show()
                return@setOnClickListener
            }

            Log.d("REGISTER", "Intentando crear usuario...")



            auth.createUserWithEmailAndPassword(correo, pass)
                .addOnSuccessListener { result ->

                    Log.d("REGISTER", "AUTH OK")

                    val uid = result.user!!.uid

                    val user = User(
                        nombre = nombre,
                        apellido = apellido,
                        correo = correo,
                        edad = edad
                    )



                    database.reference
                        .child("usuarios")
                        .child(uid)
                        .setValue(user)
                        .addOnSuccessListener {

                            Log.d("REGISTER", "DB OK")

                            Snackbar.make(
                                binding.root,
                                "Usuario creado correctamente",
                                Snackbar.LENGTH_LONG
                            ).show()

                            findNavController()
                                .navigate(R.id.action_registerFragment_to_diagloRegistroOK)
                        }
                        .addOnFailureListener {
                            Log.e("REGISTER", "DB ERROR: ${it.message}")
                        }
                }
                .addOnFailureListener {

                    Log.e("REGISTER", "AUTH ERROR: ${it.message}")

                    Snackbar.make(
                        binding.root,
                        it.message ?: "Error desconocido",
                        Snackbar.LENGTH_LONG
                    ).show()

                    findNavController()
                        .navigate(R.id.action_registerFragment_to_diagloRegistroFAIL)
                }
        }
    }
}
