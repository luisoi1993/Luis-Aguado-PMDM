package com.example.tienda.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tienda.R
import com.example.tienda.databinding.FragmentRegistroBinding
import com.example.tienda.dataset.DataSet
import com.example.tienda.model.Usuario
import com.example.tienda.ui.dialog.DialogRegistroOk
import com.google.android.material.snackbar.Snackbar

class RegisterFragment : Fragment(), View.OnClickListener, DialogRegistroOk.onBotonListener {
    private lateinit var binding: FragmentRegistroBinding
    private lateinit var listener: DialogRegistroOk.onBotonListener

    private var booleanDialogo: Boolean? = null



    override fun onAttach(context: Context) {
        super.onAttach(context)


    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val edades = (10..99).map { it.toString() }

        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            edades
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinnerEdadRegistro.adapter = adapter
        binding.spinnerEdadRegistro.setSelection(0)

        this.binding.buttonRegistro.setOnClickListener(this)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onClick(p0: View?) {
        if (p0 == binding.buttonRegistro){
            if (binding.editNombreRegistro.text.isEmpty() || binding.editApellidoRegistro.text.isEmpty() || binding.editCorreo.text.isEmpty() || binding.editContrasenia.text.isEmpty()){
                //mostrar dialogo DialogoRegistroFail
                DialogRegistroOk().show(parentFragmentManager, "okDialog")


            }else{
                //mostrar dialogo DialogoRegistroOk
                DialogRegistroOk().show(childFragmentManager, "okDialog")






            }


        }
    }

    override fun botonBoolean(boolean: Boolean?) {
        if (boolean == true){

            val nombre = binding.editNombreRegistro.text.toString()
            val apellido = binding.editApellidoRegistro.text.toString()
            val edad = binding.spinnerEdadRegistro.selectedItem.toString().toInt()
            val correo = binding.editCorreo.text.toString()
            val contrasenia = binding.editContrasenia.text.toString()
            val usuario = Usuario(nombre, apellido, edad, correo, contrasenia)
            DataSet.addUsuario(usuario)

            val snackbar = Snackbar.make(
                binding.root,
                "Usuario registrado correctamente ${DataSet.listaUsuarios[0]}",
                Snackbar.LENGTH_LONG
            )
            snackbar.show()
        }else{
            Snackbar.make(binding.root, "Usuario no registrado", Snackbar.LENGTH_LONG).show()

        }


    }
}