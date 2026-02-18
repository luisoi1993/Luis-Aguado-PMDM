// File: ui/fragments/LoginFragment.kt

package com.example.examenfinal.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.examenfinal.R
import com.example.examenfinal.databinding.FragmentFirstBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var auth: FirebaseAuth

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()

        binding.btnLogin.setOnClickListener {
            Snackbar.make(binding.root,"boton", Snackbar.LENGTH_LONG).show()
            val correo = binding.editCorreo.text.toString()
            val pass = binding.editPass.text.toString()

            auth.signInWithEmailAndPassword(correo, pass)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        Snackbar.make(binding.root,"acceso", Snackbar.LENGTH_LONG)
                    //    findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
                    } else {
                        auth.createUserWithEmailAndPassword(correo, pass)
                            .addOnCompleteListener { create ->
                                if (create.isSuccessful) {
                                    Snackbar.make(binding.root, "Usuario creado", Snackbar.LENGTH_LONG)
                                        .setAction("Login") {
                                        //    findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
                                        }.show()
                                }
                            }
                    }
                }
        }
    }
}
