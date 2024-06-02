package com.capstone.pulih.ui.auth.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation
import com.capstone.pulih.R
import com.capstone.pulih.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        Navigasi ke Register Fragment
        binding.linkRegister.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.registerFragment))

//        Menampilkan Message Menggunakan Toast
        binding.btnLogin.setOnClickListener {
            Toast.makeText(requireContext(), "Fitur Masih Coming Soon!", Toast.LENGTH_LONG).show()
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