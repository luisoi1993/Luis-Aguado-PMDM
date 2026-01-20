package com.example.agendajsondos.ui.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.example.agendajsondos.databinding.DialogDetailsBinding
import com.example.agendajsondos.model.User

class DialogDetails : DialogFragment() {

    private lateinit var binding: DialogDetailsBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        binding = DialogDetailsBinding.inflate(layoutInflater)

        val user = arguments?.getSerializable("user") as? User

        user?.let {
            binding.textName.text = "${it.firstName} ${it.lastName}"
            binding.textEmail.text = it.email
            binding.textGender.text = it.gender
            binding.textAge.text = "Edad: ${it.age}"

            Glide.with(requireContext())
                .load(it.image)
                .into(binding.imageUser)
        }

        val builder = AlertDialog.Builder(requireContext())
        builder.setView(binding.root)
            .setPositiveButton("Cerrar", null)

        return builder.create()
    }

    companion object {
        fun newInstance(user: User): DialogDetails {
            val dialog = DialogDetails()
            val args = Bundle()
            args.putSerializable("user", user)
            dialog.arguments = args
            return dialog
        }
    }
}
