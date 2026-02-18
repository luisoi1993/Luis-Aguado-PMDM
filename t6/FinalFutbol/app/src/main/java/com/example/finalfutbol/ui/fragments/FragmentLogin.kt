package com.example.finalfutbol.ui.fragments


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.finalfutbol.R
import com.example.finalfutbol.databinding.FragmentLoginBinding
import com.example.finalfutbol.dataset.Dataset
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class FragmentLogin: Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        binding.buttonIniciarSesion.setOnClickListener {
            auth.signInWithEmailAndPassword(
                binding.textViewCorreo.text.toString(),
                binding.textViewContrasena.text.toString()
            ).addOnCompleteListener {
                if (it.isSuccessful) {
                    Snackbar.make(
                        binding.root,
                        "Inicio de sesión correcto",
                        Snackbar.LENGTH_LONG
                    ).show()
                    val uid = auth.currentUser?.uid
                    Dataset.uidLogeado = uid.toString()
                   findNavController().navigate(R.id.action_fragmentLogin_to_fragmentPerfil)

                } else {
                    Snackbar.make(
                        binding.root,
                        "Inicio de sesión incorrecto",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
            }
        }

        binding.buttonRegistro.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentLogin_to_fragmentRegistro)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}