package com.example.tiendados.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.tiendados.model.User

class DialogDetalle: DialogFragment() {
    private lateinit var user: User


    override fun onAttach(context: Context) {
        super.onAttach(context)
        //traer al usuario del bundle
        user = requireArguments().getSerializable("user") as User
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        //crear el dialogo
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Detalle")
        builder.setMessage("Nombre: ${user.nombre}\n Apellido: ${user.apellido}" +
                "\nCorreo: ${user.correo}" +
                "\nEdad: ${user.edad} ")
        return builder.create()


    }
}