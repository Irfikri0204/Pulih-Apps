package com.capstone.pulih.ui.auth.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.capstone.pulih.R
import com.capstone.pulih.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        firebaseAuth = FirebaseAuth.getInstance()
//        Navigasi ke Login Fragment
        binding.linkLogin.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.loginFragment))

//        Menampilkan Message Menggunakan Toast
        binding.btnRegister.setOnClickListener {
            val email = binding.edRegisterEmail.text.toString()
            val password = binding.edRegisterPassword.text.toString()
            if (email.isNotEmpty()&&password.isNotEmpty()){
                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
                    if(it.isSuccessful){
                        findNavController().navigate(R.id.nav_register_to_login)
                        Toast.makeText(requireContext(), "Sign In Berhasil!",Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(requireContext(),it.exception.toString(),Toast.LENGTH_LONG).show()
                    }
                }
            } else {
                Toast.makeText(requireContext(),"Harap isi dengan benar!",Toast.LENGTH_LONG).show()
            }
        }
    }

}