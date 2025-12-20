package com.example.tiendados.ui.activity.dialogs

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.example.tiendados.databinding.DialogComparacionBinding
import com.example.tiendados.model.Producto

class DialogoComparacion(
    private val producto1: Producto,
    private val producto2: Producto,
    private val criterio: String
) : DialogFragment() {

    private lateinit var binding: DialogComparacionBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        binding = DialogComparacionBinding.inflate(layoutInflater)

        // Imágenes
        Glide.with(requireContext())
            .load(producto1.imagen)
            .into(binding.imgProducto1)

        Glide.with(requireContext())
            .load(producto2.imagen)
            .into(binding.imgProducto2)

        // Nombres
        binding.txtNombreProducto1.text = producto1.nombre
        binding.txtNombreProducto2.text = producto2.nombre

        // Comparación
        binding.txtResultadoComparacion.text = when (criterio) {
            "Precio" ->
                "Precio:\n${producto1.precio} €  vs  ${producto2.precio} €"

            "Categoria" ->
                "Categoría:\n${producto1.categoria}  vs  ${producto2.categoria}"

            "Stock" ->
                "Stock:\n${producto1.stock}  vs  ${producto2.stock}"

            else -> "Sin comparación"
        }

        return AlertDialog.Builder(requireContext())
            .setView(binding.root)
            .setPositiveButton("Cerrar", null)
            .create()
    }
}
