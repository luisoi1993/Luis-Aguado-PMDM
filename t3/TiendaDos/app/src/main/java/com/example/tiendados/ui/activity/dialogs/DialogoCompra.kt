package com.example.tiendados.ui.activity.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.tiendados.dataset.DataSet

class DialogoCompra : DialogFragment(){
    private lateinit var listener : OnDialogoCompraListener
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnDialogoCompraListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Pagar")
        builder.setMessage("El precio total de los productos es ${DataSet.total} €")
        builder.setPositiveButton("si"){_,_ ->
          listener.onDialogoCompra()
        }

        return builder.create()
    }

    interface OnDialogoCompraListener{
        fun onDialogoCompra()
    }
}




