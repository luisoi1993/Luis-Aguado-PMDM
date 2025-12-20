package com.example.todolist.dataset

import com.example.todolist.R
import com.example.todolist.model.Tarea

class DataSet {

    companion object {

        val listaTareas = arrayListOf(
            Tarea(R.drawable.friendkind, "Tarea 1", "Descripcion 1", "10/10/2023", "Prioritaria", "por hacer"),
            Tarea(R.drawable.housekind, "Tarea 2", "Descripcion 2", "11/10/2023", "Media", "haciendo"),
            Tarea(R.drawable.schoolkind, "Tarea 3", "Descripcion 3", "12/10/2023", "Baja", "hecho"),
            Tarea(R.drawable.friendkind, "Tarea 4", "Descripcion 4", "13/10/2023", "Prioritaria", "por hacer"),
            Tarea(R.drawable.housekind, "Tarea 5", "Descripcion 5", "14/10/2023", "Media", "haciendo"),
            Tarea(R.drawable.schoolkind, "Tarea 6", "Descripcion 6", "10/09/2025", "Prioritaria", "hecho"),
            Tarea(R.drawable.friendkind, "Tarea 7", "Descripcion 7", "10/10/2023", "Prioritaria", "por hacer"),
            Tarea(R.drawable.housekind, "Tarea 8", "Descripcion 8", "11/10/2023", "Media", "haciendo"),
            Tarea(R.drawable.schoolkind, "Tarea 9", "Descripcion 9", "12/10/2023", "Baja", "hecho"),
            Tarea(R.drawable.friendkind, "Tarea 10", "Descripcion 10", "13/10/2023", "Prioritaria", "por hacer")
        )

        fun getListaFiltrada(prioridad: String, estado: String): ArrayList<Tarea> {

            val listaFiltrada = arrayListOf<Tarea>()

            for (tarea in listaTareas) {

                val coincidePrioridad =
                    prioridad.equals("Todas", true) ||
                            tarea.prioridad.equals(prioridad, true)

                val coincideEstado =
                    estado.equals("Todas", true) ||
                            tarea.estado.equals(estado, true)

                if (coincidePrioridad && coincideEstado) {
                    listaFiltrada.add(tarea)
                }
            }

            return listaFiltrada
        }
    }
}
