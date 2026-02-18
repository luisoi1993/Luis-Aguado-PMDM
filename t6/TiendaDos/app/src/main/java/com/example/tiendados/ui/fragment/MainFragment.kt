package com.example.tiendados.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tiendados.adapter.UserAdapter
import com.example.tiendados.databinding.FragmentMainBinding
import com.example.tiendados.model.Product
import com.example.tiendados.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.gson.Gson

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private lateinit var adapter: UserAdapter

    private val listaUsuarios: ArrayList<User> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMainBinding.inflate(inflater, container, false)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()

        adapter = UserAdapter(listaUsuarios, requireContext())
        binding.recyclerProductos.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerProductos.adapter = adapter

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        val listaProductos: ArrayList<Product> = ArrayList()

        database.reference
            .child("productos")
            .child("products")
            .addChildEventListener(object : ChildEventListener {

                override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                    val gson = Gson()
                    val json = gson.toJson(snapshot.value)
                    val product = gson.fromJson(json, Product::class.java)
                    Log.v("FIREBASE", "Producto añadido: ${product.weight}")
                    listaProductos.add(product)


                }

                override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {}

                override fun onChildRemoved(snapshot: DataSnapshot) {}

                override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {}

                override fun onCancelled(error: DatabaseError) {}
            })

        cargarUsuariosFirebase()
        cargarUsuarioLogeado()
    }


    private fun cargarUsuariosFirebase() {

        database.reference.child("usuarios")
            .addValueEventListener(object : ValueEventListener {

                override fun onDataChange(snapshot: DataSnapshot) {

                    listaUsuarios.clear()

                    for (child in snapshot.children) {
                        val user = child.getValue(User::class.java)
                        user?.let { listaUsuarios.add(it) }
                    }

                    adapter.notifyDataSetChanged()
                }

                override fun onCancelled(error: DatabaseError) {}
            })
    }

    // 🔥 SOLO USUARIO ACTUAL
    private fun cargarUsuarioLogeado() {

        val uid = auth.currentUser?.uid ?: return

        database.reference.child("usuarios").child(uid)
            .addListenerForSingleValueEvent(object : ValueEventListener {

                override fun onDataChange(snapshot: DataSnapshot) {
                    val user = snapshot.getValue(User::class.java)
                    binding.textNombreMain.text = user?.nombre ?: "Usuario"
                }

                override fun onCancelled(error: DatabaseError) {}
            })
    }
}
