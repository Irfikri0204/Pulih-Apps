package com.capstone.pulih.ui.auth.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.capstone.pulih.R
import com.capstone.pulih.databinding.FragmentLoginBinding
import com.capstone.pulih.utils.AuthConstant
import com.capstone.pulih.utils.Preferences
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var sharedPref:Preferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firebaseAuth = FirebaseAuth.getInstance()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        Navigasi ke Register Fragment
        binding.linkRegister.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.registerFragment))

//        Menampilkan Message Menggunakan Toast
        binding.btnLogin.setOnClickListener {
//            Mengambil String dari Input
            val email = binding.edLoginEmail.text.toString()
            val password = binding.edLoginPassword.text.toString()
//            Pengkondisian Inputan
            if (email.isNotEmpty()&&password.isNotEmpty()){
//                Firebase Login
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener{
                    if(it.isSuccessful){
                        sharedPref = Preferences(requireActivity())
                        sharedPref.put(AuthConstant.PREF_IS_LOGIN,true)
                        findNavController().navigate(R.id.nav_login_to_main)
                        Toast.makeText(requireContext(), "Login Berhasil!",Toast.LENGTH_LONG).show()
                        requireActivity().finish()
                    } else {
                        Toast.makeText(requireContext(),it.exception.toString(),Toast.LENGTH_LONG).show()
                    }
                }
            } else {
                Toast.makeText(requireContext(),"Harap isi dengan benar!",Toast.LENGTH_LONG).show()
            }
        }

//        Mengecek Argumen is_from_register
        val isFromRegister: Boolean? = arguments?.getBoolean("is_from_register")
        if (isFromRegister != null && isFromRegister) {
            onBackPressed()
        }
    }

    private fun onBackPressed() {
        activity?.onBackPressedDispatcher?.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    requireActivity().finish()
                }
            })
    }

}