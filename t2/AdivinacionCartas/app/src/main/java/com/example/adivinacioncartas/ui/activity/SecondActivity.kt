package com.example.adivinacioncartas.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.adivinacioncartas.MainActivity
import com.example.adivinacioncartas.R
import com.example.adivinacioncartas.databinding.ActivitySecondBinding
import com.google.android.material.snackbar.Snackbar
import kotlin.jvm.java

class SecondActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivitySecondBinding

    private var mayorMenor : Boolean? = null

    private var carta : Int? = null

    private var carta2 : Int? = null

    private var puntacion : Int = 0




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        acciones(savedInstanceState)

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("puntuacion", puntacion)
        outState.putInt("carta", carta!!)
        outState.putInt("carta2", carta2!!)
        outState.putBoolean("mayorMenor", mayorMenor ?: false)

    }

    private fun acciones(savedInstanceState: Bundle?) {

        binding.butonAbajo.setOnClickListener(this)
        binding.butonArriba.setOnClickListener(this)

        if(savedInstanceState == null){
            val nombre = intent.getStringExtra("nombre")

            val snackbar = Snackbar.make(binding.root, "Bienvenido $nombre", Snackbar.LENGTH_INDEFINITE)
            snackbar.setAction("Empezar"){
                juego()
            }
            snackbar.show()


            carta = (1..13).random()
            carta2 = (1..13).random()
        } else {
            puntacion = savedInstanceState.getInt("puntuacion")
            carta = savedInstanceState.getInt("carta")
            carta2 = savedInstanceState.getInt("carta2")
            mayorMenor = savedInstanceState.getBoolean("mayorMenor")
            juego()
        }


    }

    private fun juego(){


        when(carta){
            1 -> binding.main.setBackgroundResource(R.drawable.c1)
            2 -> binding.main.setBackgroundResource(R.drawable.c2)
            3 -> binding.main.setBackgroundResource(R.drawable.c3)
            4 -> binding.main.setBackgroundResource(R.drawable.c4)
            5 -> binding.main.setBackgroundResource(R.drawable.c5)
            6 -> binding.main.setBackgroundResource(R.drawable.c6)
            7 -> binding.main.setBackgroundResource(R.drawable.c7)
            8 -> binding.main.setBackgroundResource(R.drawable.c8)
            9 -> binding.main.setBackgroundResource(R.drawable.c9)
            10 -> binding.main.setBackgroundResource(R.drawable.c10)
            11 -> binding.main.setBackgroundResource(R.drawable.c11)
            12 -> binding.main.setBackgroundResource(R.drawable.c12)
            13 -> binding.main.setBackgroundResource(R.drawable.c13)
        }


    }

    private fun comprobarJugada(){
        if(carta!! > carta2!! && mayorMenor == true){

            val snackbar = Snackbar.make(binding.root, "Has perdido, tu puntacion es $puntacion", Snackbar.LENGTH_INDEFINITE)
            snackbar.setAction("Volver a inicio") {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            snackbar.show()
        } else if(carta!! > carta2!! && mayorMenor == false){

                puntacion++
                carta = carta2
                carta2 = (1..13).random()
                juego()


        } else if(carta2!! > carta!! && mayorMenor == true){
            puntacion++
            carta = carta2
            carta2 = (1..13).random()
            juego()
        } else if(carta2!! > carta!! && mayorMenor == false){
            val snackbar = Snackbar.make(binding.root, "Has perdido, tu puntacion es $puntacion", Snackbar.LENGTH_INDEFINITE)
            snackbar.setAction("Volver a inicio") {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            snackbar.show()
        } else if(carta2!! == carta!!){
            val snackbar = Snackbar.make(binding.root, "Las cartas son iguales, tu puntuación es:  $puntacion", Snackbar.LENGTH_SHORT).show()
            carta = carta2
            carta2 = (1..13).random()
            juego()
        }


    }

    override fun onClick(p0: View?) {

        when(p0?.id){

            R.id.butonArriba -> {
                binding.butonArriba.setImageResource(R.drawable.up_press)

                // Volver a la imagen original después de 150 ms
                binding.butonArriba.postDelayed({
                    binding.butonArriba.setImageResource(R.drawable.up)
                }, 150)
                mayorMenor = true
                comprobarJugada()
            }

            R.id.butonAbajo -> {
                binding.butonAbajo.setImageResource(R.drawable.down_press)

                binding.butonAbajo.postDelayed({
                    binding.butonAbajo.setImageResource(R.drawable.down)
                },150)

                mayorMenor = false
                comprobarJugada()
            }


        }

    }
}