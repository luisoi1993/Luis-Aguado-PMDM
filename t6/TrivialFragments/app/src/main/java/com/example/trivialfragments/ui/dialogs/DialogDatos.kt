package com.example.trivialfragments.ui.dialogs


import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.trivialfragments.dataset.DataSet

class DialogDatos: DialogFragment() {

    //crear el dialogo ponerle titulo y texto

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Datos")
        builder.setMessage("Nombre: ${DataSet.usuarioLogeado.nick}\nCorreo: ${DataSet.usuarioLogeado.correo
        }\nEdad: ${DataSet.usuarioLogeado.edad} años ")
        return builder.create()

    }
}