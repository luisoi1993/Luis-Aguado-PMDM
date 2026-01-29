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
        builder.setPositiveButton("Si",{view,position ->})
        builder.setNegativeButton("No", {view,position ->})

        return builder.create()
    }
}