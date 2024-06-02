package com.capstone.pulih.ui.auth.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.capstone.pulih.R
import com.capstone.pulih.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        Navigasi ke Login Fragment
        binding.linkLogin.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.loginFragment))

//        Menampilkan Message Menggunakan Toast
        binding.btnRegister.setOnClickListener {
            Toast.makeText(requireContext(), "Fitur Masih Coming Soon!", Toast.LENGTH_LONG).show()
        }
    }

}