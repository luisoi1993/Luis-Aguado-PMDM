package com.example.agendajsontres.ui.activities

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.agendajsontres.R
import com.example.agendajsontres.adapter.FavoritoAdapter
import com.example.agendajsontres.adapter.UserAdapter
import com.example.agendajsontres.databinding.ActivityFavoritoBinding
import com.example.agendajsontres.dataset.DataSet
import com.example.agendajsontres.model.User
import com.example.agendajsontres.ui.dialog.DialogUser

class FavoritoActivity : AppCompatActivity(), FavoritoAdapter.OnFavDetailSelected {


    private lateinit var binding: ActivityFavoritoBinding
    private lateinit var adapter: FavoritoAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFavoritoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancias()
        initGUI()

    }

    private fun instancias() {
        adapter = FavoritoAdapter(this, DataSet.favoritos)


    }

    private fun initGUI() {
        binding.recyclerUsers.adapter = adapter;
        binding.recyclerUsers.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }

    override fun onFavDetailSelected(user: User) {
        val dialogo = DialogUser.newInstance(user)
        dialogo.show(supportFragmentManager, null)

    }


}