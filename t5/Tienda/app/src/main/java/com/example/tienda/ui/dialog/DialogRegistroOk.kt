package com.example.tienda.ui.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogRegistroOk: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())

        builder.setTitle("Registro correcto")
        builder.setMessage("¿Quieres registrarte?")

        builder.setPositiveButton("Si") { _, _ ->
            (parentFragment as? onBotonListener)?.botonBoolean(true)
        }

        builder.setNegativeButton("No") { _, _ ->
            (parentFragment as? onBotonListener)?.botonBoolean(false)
        }

        return builder.create()
    }

    interface onBotonListener{
        fun botonBoolean(boolean: Boolean?)
    }
}
