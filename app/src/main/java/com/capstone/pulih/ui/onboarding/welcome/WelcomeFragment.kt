package com.capstone.pulih.ui.onboarding.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.capstone.pulih.R
import com.capstone.pulih.databinding.FragmentWelcomeBinding
import com.capstone.pulih.utils.AuthConstant
import com.capstone.pulih.utils.Preferences

class WelcomeFragment : Fragment() {
    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var sharedPref: Preferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLoginUser.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.loginFragment))
        binding.btnLoginCounselor.setOnClickListener{
            comingSoon()
        }
    }
    private fun comingSoon(){
        Toast.makeText(requireContext(), getString(R.string.coming_soon), Toast.LENGTH_LONG).show()
    }

    override fun onStart() {
        super.onStart()
        sharedPref = Preferences(requireActivity())
        if(sharedPref.getBoolean(AuthConstant.PREF_IS_LOGIN)){
            findNavController().navigate(R.id.nav_welcome_to_main)
            requireActivity().finish()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}