package com.example.agendajson.ui.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogoFiltrar: DialogFragment() {
    private lateinit var elementos: Array<String>
    private lateinit var seleccionados: BooleanArray

    override fun onAttach(context: Context) {
        super.onAttach(context)
        elementos = arrayOf(
            "Hombre",
            "Mujer",
            "Todos"
        )
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {



        seleccionados = BooleanArray(elementos.size)

        val builder = AlertDialog.Builder(requireContext())

        builder.setTitle("Filtrar")
            /*
            .setMultiChoiceItems(elementos, seleccionados) { _, which, isChecked ->
                seleccionados[which] = isChecked
            }
            */
            .setSingleChoiceItems(elementos, -1) { _, which ->
                seleccionados[which] = true
            }
            .setPositiveButton("Aceptar") { _, _ ->
                val categoriasSeleccionadas = mutableListOf<String>()

                for (i in elementos.indices) {
                    if (seleccionados[i]) {
                        categoriasSeleccionadas.add(elementos[i])
                    }
                }


            }
            .setNegativeButton("Cancelar", null)

        return builder.create()
    }
}