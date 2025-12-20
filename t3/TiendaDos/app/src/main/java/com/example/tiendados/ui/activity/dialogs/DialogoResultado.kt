package com.example.tiendados.ui.activity.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.tiendados.model.Producto

class DialogoResultado: DialogFragment() {
    private lateinit var producto1: Producto
    private lateinit var producto2: Producto
    private lateinit var comparacion: String


    companion object{
        fun newInstance(producto1: Producto, producto2: Producto, comparacion: String): DialogoResultado{
            val dialogoResultado = DialogoResultado()
            val bundle = Bundle()
            bundle.putString("comparacion",comparacion)
            bundle.putSerializable("producto1",producto1)
            bundle.putSerializable("producto2",producto2)
            dialogoResultado.arguments = bundle
            return dialogoResultado
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        //recupero los argumentos
       val bundle: Bundle? = this.arguments
        producto1 = bundle?.getSerializable("producto1") as Producto
        producto2 = bundle.getSerializable("producto2") as Producto
        comparacion = bundle.getString("comparacion").toString()

    }

   override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

       val builder = AlertDialog.Builder(requireContext())
       //el xml -> layoyt inflater
       //builder.setview()
       //eztraer cada elemento del xml -> binding // findViewById
       builder.setTitle(comparacion)
       builder.setMessage("El producto ${producto1.nombre} es $comparacion con el producto ${producto2.nombre}")

        return super.onCreateDialog(savedInstanceState)
    }
}