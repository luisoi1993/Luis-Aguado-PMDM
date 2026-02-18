

package com.example.examenfinal.ui.fragments

import android.content.Context
import android.os.Bundle
import com.example.examenfinal.dataset.DataSet
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.examenfinal.R
import com.example.examenfinal.databinding.FragmentFirstBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var auth: FirebaseAuth

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
        setHasOptionsMenu(true)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()



        binding.btnLogin.setOnClickListener {
            Snackbar.make(binding.root,"boton", Snackbar.LENGTH_LONG).show()
            val correo = binding.editCorreo.text.toString()
            val pass = binding.editPass.text.toString()

            auth.signInWithEmailAndPassword(correo, pass)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        DataSet.usuarioLogeado = true
                        findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
                    } else {
                        auth.createUserWithEmailAndPassword(correo, pass)
                            .addOnCompleteListener { create ->
                                if (create.isSuccessful) {
                                    Snackbar.make(binding.root, "Usuario creado", Snackbar.LENGTH_LONG)
                                        .setAction("Login") {
                                            DataSet.usuarioLogeado = true
                                            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
                                        }.show()
                                }
                            }
                    }
                }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
        menu.add(0, 1, 0, "Favoritos")

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == 1) {
            Snackbar.make(binding.root,"Tienes que estar conectado", Snackbar.LENGTH_LONG).show()

        }
        return super.onOptionsItemSelected(item)
    }
}
