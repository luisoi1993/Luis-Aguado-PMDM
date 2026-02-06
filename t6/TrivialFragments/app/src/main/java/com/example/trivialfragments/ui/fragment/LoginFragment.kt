package com.example.trivialfragments.ui.fragment


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.trivialfragments.R
import com.example.trivialfragments.databinding.FragmentLoginBinding
import com.example.trivialfragments.dataset.DataSet
import com.example.trivialfragments.ui.activities.GameActivity
import com.google.android.material.snackbar.Snackbar

class LoginFragment: Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentLoginBinding

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
        binding.buttonRegister.setOnClickListener(this)
        binding.buttonLogin.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if (p0 == binding.buttonRegister) {

            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
        if (p0 == binding.buttonLogin) {

            if (DataSet.comprobarUsuario(
                    binding.editTextCorreo.text.toString(),
                    binding.editTextPassword.text.toString()
                )) {

                for (usuario in DataSet.listaUsuarios) {
                    if (usuario.correo == binding.editTextCorreo.text.toString() && usuario.password == binding.editTextPassword.text.toString())
                        DataSet.usuarioLogeado = usuario
                    break


                }
                Snackbar.make(
                    binding.root,
                    "Bienvenido ${DataSet.usuarioLogeado.nick}",
                    Snackbar.LENGTH_SHORT
                ).show()

            }

          //  findNavController().navigate(R.id.action_loginFragment_to_gameActivity)


        }
    }


}