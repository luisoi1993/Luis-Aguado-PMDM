package com.example.agendajson.ui.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogoDetalle: DialogFragment() {
    private lateinit var elementos: Array<String>
    private lateinit var seleccionados: BooleanArray


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        elementos = arrayOf(
            "Beauty",
            "Fragrances",
            "Furniture",
            "Groceries",
            "Home Decoration",
            "Kitchen Accessories"
        )

        seleccionados = BooleanArray(elementos.size)

        val builder = AlertDialog.Builder(requireContext())

        builder.setTitle("Filtrar por categorías")
            .setMultiChoiceItems(elementos, seleccionados) { _, which, isChecked ->
                seleccionados[which] = isChecked
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