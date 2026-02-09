package com.example.trivialfragments.ui.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.trivialfragments.dataset.DataSet
import com.example.trivialfragments.model.Pregunta
import com.example.trivialfragments.ui.activities.GameActivity

class QuestionDialog : DialogFragment() {

    private lateinit var pregunta: Pregunta

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        pregunta = arguments?.getSerializable("pregunta") as Pregunta

        val builder = AlertDialog.Builder(requireContext())

        builder.setTitle(pregunta.question)

        val opciones = ArrayList<String>()
        opciones.add(pregunta.correct_answer)
        opciones.addAll(pregunta.incorrect_answers)
        opciones.shuffle()

        builder.setItems(opciones.toTypedArray()) { dialogInterface, i ->
            if (opciones[i] == pregunta.correct_answer) {
                DataSet.puntuacion++
                (activity as? GameActivity)?.actualizarAciertos()
                DataSet.ponerRecord(DataSet.puntuacion, DataSet.usuarioLogeado.nick)

            }
            dialogInterface.dismiss()
        }

        return builder.create()
    }
}
