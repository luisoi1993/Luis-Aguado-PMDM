package com.example.trivialfragments.ui.activities

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.trivialfragments.R
import com.example.trivialfragments.databinding.ActivityGameBinding
import com.example.trivialfragments.dataset.DataSet
import com.example.trivialfragments.model.Pregunta
import com.example.trivialfragments.ui.dialogs.DialogDatos
import com.example.trivialfragments.ui.dialogs.QuestionDialog
import com.google.gson.Gson

class GameActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

       setSupportActionBar(binding.toolbar)

        //cambiar el titulo del toolbar
        supportActionBar?.title = DataSet.usuarioLogeado.nick



    }

    override fun onResume() {
        super.onResume()
        this.binding.buttonJugar.setOnClickListener(this)
    }

    //sobrescribir las dos funciones del menu

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_game, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

         when (item.itemId) {
             R.id.menu_sesion -> {
                 onBackPressed()
                 return true
             }
             R.id.menu_informacion -> {
                 val dialog = DialogDatos()
                 dialog.show(supportFragmentManager, "DialogDatos")
                 return true
             }
             else -> super.onOptionsItemSelected(item)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(p0: View?) {
        if (p0 == binding.buttonJugar) {
            val numeroPreguntas = binding.editTextNumeroPreguntas.text.toString().toIntOrNull() ?: 10
            DataSet.puntuacion = 0

            val urlConsulta = "https://opentdb.com/api.php?amount=20"
            val gson: Gson = Gson()
            val peticion: JsonObjectRequest = JsonObjectRequest(urlConsulta,
                {
                    val results = it.getJSONArray("results")
                    for (i in 0..<results.length()) {
                        val question = results.getJSONObject(i)
                        val pregunta: Pregunta = gson.fromJson(question.toString(),Pregunta::class.java)
                        Log.v("preguntas", pregunta.question)
                        val bundle = Bundle()
                        bundle.putSerializable("pregunta",pregunta)
                        val dialog = QuestionDialog()
                        dialog.arguments = bundle
                        dialog.show(supportFragmentManager, "DialogPregunta")


                    }
                },
                {
                    Log.v("preguntas","${it.message}")
                })
            Volley.newRequestQueue(this).add(peticion)
        }
    }


}

