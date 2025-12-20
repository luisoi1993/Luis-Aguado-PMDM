package com.example.tiendados.ui.activity.dialogs

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import kotlin.math.log

class DialogoInformacion: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())

        builder.setTitle("Informacion de la APP")
        builder.setMessage("Esta app ha sido realiza para analizar datos de el recycler view")
        builder.setPositiveButton("Ok", {_,_ ->{
            Log.v("dialogo","pulsado el boton positivo")
        }})

        builder.setNegativeButton("Ok", {_,_ ->{
            Log.v("dialogo","pulsado el boton positivo")
        }})

        builder.setNeutralButton("Ok", {_,_ ->{
            Log.v("dialogo","pulsado el boton positivo")
        }})

        return builder.create()
    }
}