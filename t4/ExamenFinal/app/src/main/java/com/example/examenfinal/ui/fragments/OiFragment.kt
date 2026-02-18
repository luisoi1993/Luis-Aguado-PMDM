package com.example.examenfinal.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.examenfinal.databinding.FragmentFirstBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class OiFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()

        database = FirebaseDatabase.getInstance(
            "https://examen-bfef3-default-rtdb.europe-west1.firebasedatabase.app/"
        )

        binding.buttonFirst.setOnClickListener {

            val email = "test${System.currentTimeMillis()}@test.com"
            val pass = "123456"

            auth.createUserWithEmailAndPassword(email, pass)
                .addOnSuccessListener { result ->

                    val uid = result.user!!.uid

                    val datos = mapOf(
                        "nombre" to "Prueba",
                        "mensaje" to "Firebase funciona"
                    )

                    database.reference
                        .child("test")
                        .child(uid)
                        .setValue(datos)
                        .addOnSuccessListener {
                            Snackbar.make(binding.root, "✅ Auth + DB OK", Snackbar.LENGTH_LONG).show()
                        }
                        .addOnFailureListener {
                            Snackbar.make(binding.root, "DB ERROR: ${it.message}", Snackbar.LENGTH_LONG).show()
                        }
                }
                .addOnFailureListener {
                    Snackbar.make(binding.root, "AUTH ERROR: ${it.message}", Snackbar.LENGTH_LONG).show()
                }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
