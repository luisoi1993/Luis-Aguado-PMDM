package com.example.agendajsondos.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogFilter : DialogFragment() {

    private lateinit var opciones: Array<CharSequence>
    private var seleccion: Int = -1
    private lateinit var listener: OnFilterSelectedListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        opciones = arrayOf("male", "female", "Todos")
        listener = context as OnFilterSelectedListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(requireContext())

        builder.setTitle("Filter")
            .setSingleChoiceItems(opciones, -1) { _, which ->
                seleccion = which
            }
            .setPositiveButton("OK") { _, _ ->
                if (seleccion != -1) {
                    val opcionElegida = opciones[seleccion].toString()
                    listener.onFilterSelected(opcionElegida)
                }
            }
            .setNegativeButton("Cancelar", null)

        return builder.create()
    }

    interface OnFilterSelectedListener {
        fun onFilterSelected(filtro: String)
    }
}
