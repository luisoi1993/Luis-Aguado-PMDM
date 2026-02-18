

package com.example.examenfinal.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examenfinal.adapter.LaunchAdapter
import com.example.examenfinal.databinding.FragmentThirdBinding
import com.example.examenfinal.dataset.DataSet
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class ThirdFragment : Fragment() {

    private lateinit var binding: FragmentThirdBinding
    private lateinit var adapter: LaunchAdapter
    private lateinit var auth: FirebaseAuth

    override fun onAttach(context: Context) {
        super.onAttach(context)
        adapter = LaunchAdapter(context)
        auth = FirebaseAuth.getInstance()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()

        if (auth.currentUser == null) {
            Snackbar.make(binding.root, "Debes iniciar sesión", Snackbar.LENGTH_SHORT).show()
            return
        }

        binding.recyclerFav.adapter = adapter
        binding.recyclerFav.layoutManager = LinearLayoutManager(requireContext())

        adapter.clear()
        for (l in DataSet.favoritos) {
            adapter.addLaunch(l)
        }
    }
}
