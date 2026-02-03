package com.example.trivialfragments.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.trivialfragments.R
import com.example.trivialfragments.databinding.FragmentLoginBinding

class LoginFragment: Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onResume() {
        super.onResume()
        binding.buttonRegister.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if (p0 == binding.buttonRegister) {

            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }


}