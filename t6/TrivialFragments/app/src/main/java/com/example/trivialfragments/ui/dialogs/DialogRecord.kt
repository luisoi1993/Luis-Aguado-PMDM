package com.example.trivialfragments.ui.dialogs

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.trivialfragments.dataset.DataSet

class DialogRecord: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Record")
        builder.setMessage("El record es ${DataSet.record} y el nick es ${DataSet.nickRecord}")
        builder.setPositiveButton("Aceptar", null)
        return builder.create()

    }


}