package com.example.tiendados.ui.activity.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogoComparar : DialogFragment() {

    private var opcionSeleccionada: String? = null
    private lateinit var listener: OnCompararListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnCompararListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())

        val opciones = arrayOf("Precio", "Categoria", "Stock")

        builder.setTitle("Comparar productos")
        builder.setSingleChoiceItems(opciones, -1) { _, position ->
            opcionSeleccionada = opciones[position]
        }

        builder.setPositiveButton("Seleccionar") { _, _ ->
            listener.onCompararSelected(opcionSeleccionada)
            dismiss()
        }

        return builder.create()
    }

    interface OnCompararListener {
        fun onCompararSelected(opcion: String?)
    }
}
