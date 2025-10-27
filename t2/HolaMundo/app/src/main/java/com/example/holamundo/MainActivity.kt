package com.example.holamundo

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.holamundo.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acciones()
        Log.v("ciclo_vida","Ejecutando metodo onCreate")


    }

    private fun acciones(){
        binding.botonSaludar.setOnClickListener{
            var snakbar = Snackbar.make(it,"Saludo: "+resources.getString(R.string.saludo_snack),Snackbar.LENGTH_LONG)
            snakbar.setAction("Ocultar"){snakbar.dismiss()}
            snakbar.show()
        }

    }

    override fun onRestart() {
        super.onRestart()
        Log.v("ciclo_vida","Ejecutando metodo onRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.v("ciclo_vida","Ejecutando metodo onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.v("ciclo_vida","Ejecutando metodo onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.v("ciclo_vida","Ejecutando metodo onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.v("ciclo_vida","Ejecutando metodo onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("ciclo_vida","Ejecutando metodo onDestroy")
    }

}