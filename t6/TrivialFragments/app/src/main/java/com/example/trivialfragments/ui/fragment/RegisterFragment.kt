package com.example.trivialfragments.ui.fragment

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.trivialfragments.databinding.FragmentRegisterBinding
import com.example.trivialfragments.dataset.DataSet
import com.example.trivialfragments.model.Usuario

class RegisterFragment: Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentRegisterBinding



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        binding.buttonRegister.setOnClickListener(this)
        binding.spinnerEdad.adapter = ArrayAdapter(
            requireContext(),
            R.layout.simple_spinner_item,
            listOf("18", "19", "20", "21", "22", "23", "24", "2")
        )
    }


    override fun onClick(p0: View?) {
        if (p0 == binding.buttonRegister) {
            val nick = binding.editTextNick.text.toString()
            val correo = binding.editTextCorreo.text.toString()
            val password = binding.editTextPassword.text.toString()
            val edad = binding.spinnerEdad.selectedItem.toString().toInt()

            if (nick.isNotEmpty() && correo.isNotEmpty() && password.isNotEmpty()) {
                DataSet.comprobarNick(nick)
                DataSet.comprobarCorreo(correo)
                if (!DataSet.comprobarNick(nick) && !DataSet.comprobarCorreo(correo) && password.length >= 6) {
                    val user = Usuario(nick, correo, password, edad)
                    DataSet.addUsuario(user)
                    binding.editTextNick.text.clear()
                    binding.editTextCorreo.text.clear()
                    binding.editTextPassword.text.clear()
                    findNavController().popBackStack()
                } else if (DataSet.comprobarNick(nick)) {
                    binding.editTextNick.error = "El nick ya existe"
                } else if (DataSet.comprobarCorreo(correo)) {
                    binding.editTextCorreo.error = "El correo ya existe"
                } else if (password.length < 6) {
                    binding.editTextPassword.error =
                        "La contraseña debe tener al menos 6 caracteres"

                }
            } else {
                if (nick.isEmpty()) {
                    binding.editTextNick.error = "El nick no puede estar vacío"
                }
                if (correo.isEmpty()) {
                    binding.editTextCorreo.error = "El correo no puede estar vacío"
                }
                if (password.isEmpty()) {
                    binding.editTextPassword.error = "La contraseña no puede estar vacía"
                }
            }

        }

    }

}