package com.capstone.pulih.ui.main.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.capstone.pulih.R
import com.capstone.pulih.databinding.FragmentProfileBinding
import com.capstone.pulih.ui.inputdata.InputDataActivity
import com.capstone.pulih.ui.onboarding.welcome.WelcomeActivity
import com.capstone.pulih.utils.AuthConstant
import com.capstone.pulih.utils.Preferences

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private lateinit var sharedPref: Preferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvEdit.setOnClickListener {
            sharedPref = Preferences(requireActivity())
            sharedPref.put(AuthConstant.PREF_IS_INPUT,false)
            val intent = Intent(activity, InputDataActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }
        binding.tvChangePw.setOnClickListener {
            comingSoon()
        }
        binding.tvDeleteAccount.setOnClickListener {
            comingSoon()
        }
        binding.tvLogout.setOnClickListener {
            sharedPref = Preferences(requireActivity())
            sharedPref.put(AuthConstant.PREF_IS_LOGIN,false)
            sharedPref.put(AuthConstant.PREF_IS_INPUT,false)
            Toast.makeText(requireContext(), "Anda telah log out!", Toast.LENGTH_LONG).show()
            val intent = Intent(activity, WelcomeActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }
    }
    private fun comingSoon(){
        Toast.makeText(requireContext(), getString(R.string.coming_soon), Toast.LENGTH_LONG).show()
    }
}