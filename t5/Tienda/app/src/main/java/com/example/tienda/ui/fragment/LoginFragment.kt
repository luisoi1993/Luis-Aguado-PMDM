package com.example.tienda.ui.fragment

import android.content.Context
import android.os.Bundle
import android.service.autofill.Dataset
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tienda.R
import com.example.tienda.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onResume() {
        super.onResume()
        binding.buttonRegistro.setOnClickListener {
            if(Dataset.loginUser(binding.editCorreo.text.toString(), binding.editContrasenia.text.toString())){
                findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
            }else {
                Snackbar.make(
                    binding.root,
                    "Usuario no registrado",
                    Snackbar.LENGTH_LONG
                )
                    .setAction("Quieres registrarlo",{findNavController()})
                    .show()
            }

        }

        binding.buttonLogin.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
        }



    }
}