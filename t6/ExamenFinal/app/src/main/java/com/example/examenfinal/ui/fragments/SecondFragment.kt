

package com.example.examenfinal.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.examenfinal.R
import com.example.examenfinal.adapter.LaunchAdapter
import com.example.examenfinal.databinding.FragmentSecondBinding
import com.example.examenfinal.model.Launch
import com.google.firebase.auth.FirebaseAuth
import com.google.gson.Gson

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private lateinit var adapter: LaunchAdapter
    private lateinit var auth: FirebaseAuth

    override fun onAttach(context: Context) {
        super.onAttach(context)
        setHasOptionsMenu(true)
        adapter = LaunchAdapter(context)
        auth = FirebaseAuth.getInstance()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()

        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(requireContext())

        cargarDatos()
    }

    private fun cargarDatos() {
        val gson = Gson()

        val request = JsonArrayRequest(
            "https://api.spacexdata.com/v5/launches",
            {
                for (i in 0 until it.length()) {
                    val obj = gson.fromJson(it.getJSONObject(i).toString(), Launch::class.java)
                    adapter.addLaunch(obj)
                }
            },
            {}
        )

        Volley.newRequestQueue(requireContext()).add(request)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
        menu.add(0, 1, 0, "Favoritos")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == 1) {
            parentFragmentManager.beginTransaction()
            requireActivity().supportFragmentManager
            val action = R.id.action_secondFragment_to_thirdFragment
            view?.let { androidx.navigation.Navigation.findNavController(it).navigate(action) }
        }
        return super.onOptionsItemSelected(item)
    }


}
