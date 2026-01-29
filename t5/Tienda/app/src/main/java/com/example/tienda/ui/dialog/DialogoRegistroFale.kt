package com.example.tienda.ui.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogoRegistroFale: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Error")
        builder.setMessage("Algo ha fallafo")
        builder.setPositiveButton("ok", null)


        return builder.create()
    }
}