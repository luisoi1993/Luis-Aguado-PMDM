package com.example.tiendados.ui.activity.dialogs

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.tiendados.dataset.DataSet

class DialogoBoton(
    val onResultado: (Boolean) -> Unit
): DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())

        builder.setTitle("Añadir producto al carrito")
        builder.setMessage("¿Quieres añadir este producto al carrito?")

        builder.setPositiveButton("Sí") { _, _ ->
            onResultado(true)
        }

        builder.setNegativeButton("No") { _, _ ->
            onResultado(false)
        }

        return builder.create()
    }
}
