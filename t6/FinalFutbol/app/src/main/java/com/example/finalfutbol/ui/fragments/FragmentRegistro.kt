package com.example.finalfutbol.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.finalfutbol.R
import com.example.finalfutbol.databinding.FragmentRegistroBinding
import com.example.finalfutbol.model.User
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class FragmentRegistro : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentRegistroBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = FirebaseAuth.getInstance()


        database = FirebaseDatabase.getInstance(
            "https://futbol-8e489-default-rtdb.europe-west1.firebasedatabase.app/"
        )
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
        binding.buttonRegistrarse.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        if (v != binding.buttonRegistrarse) return

        val nombre = binding.EditTextNombre.text.toString()
        val apellido = binding.EditTextApellido.text.toString()
        val telefonoString = binding.EditTextTelefono.text.toString()
        val correo = binding.EditTextCorreo.text.toString()
        val contrasena = binding.EditTextContrasena.text.toString()
        val direccion = binding.EditTextDireccion.text.toString()


        if (nombre.isEmpty() ||
            apellido.isEmpty() ||
            telefonoString.isEmpty() ||
            correo.isEmpty() ||
            contrasena.isEmpty() ||
            direccion.isEmpty()
        ) {
            Snackbar.make(binding.root, "Todos los campos son obligatorios", Snackbar.LENGTH_SHORT).show()
            return
        }

        val telefono = telefonoString.toInt()


        auth.createUserWithEmailAndPassword(correo, contrasena)
            .addOnSuccessListener { result ->

                val uid = result.user?.uid ?: return@addOnSuccessListener

                val user = User(
                    nombre,
                    apellido,
                    telefono,
                    correo,
                    contrasena,
                    direccion
                )


                database.reference
                    .child("users")
                    .child(uid)
                    .setValue(user)
                    .addOnSuccessListener {
                        Snackbar.make(binding.root, "Usuario registrado correctamente", Snackbar.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.action_fragmentRegistro_to_fragmentLogin)
                    }
                    .addOnFailureListener {
                        Snackbar.make(binding.root, "Error DB: ${it.message}", Snackbar.LENGTH_LONG).show()
                    }
            }
            .addOnFailureListener {
                Snackbar.make(binding.root, "Error Auth: ${it.message}", Snackbar.LENGTH_LONG).show()
            }
    }
}
