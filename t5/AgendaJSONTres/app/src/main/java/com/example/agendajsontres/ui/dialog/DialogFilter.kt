package com.example.agendajsontres.ui.dialog


import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.agendajsontres.MainActivity
import java.util.Locale
import java.util.Locale.getDefault

class DialogFilter : DialogFragment() {

    private lateinit var opciones: Array<CharSequence>
    private lateinit var listener: OnDialogoFiltrarListener
    private var posicion: Int = -1

    override fun onAttach(context: Context) {
        super.onAttach(context)
        opciones = arrayOf("Male", "Female", "All")
        listener = context as MainActivity
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())

        builder.setTitle("Filter")
        builder.setSingleChoiceItems(
            opciones, -1,
            { _, p ->
                posicion = p
            })
        builder.setPositiveButton("OK", { v, p ->
            listener.onGeneroSelected(opciones[posicion].toString().lowercase(Locale.ROOT))
        })

        return builder.create()
    }

    interface OnDialogoFiltrarListener {
        fun onGeneroSelected(genero: String)
    }
}