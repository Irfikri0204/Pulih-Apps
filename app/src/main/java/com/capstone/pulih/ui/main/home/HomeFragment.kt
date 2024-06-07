package com.capstone.pulih.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.capstone.pulih.R
import com.capstone.pulih.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnDeteksi.setOnClickListener {
            comingSoon()
        }
        binding.btnIntro.setOnClickListener {
            comingSoon()
        }
        binding.linkKonseling.setOnClickListener {
            comingSoon()
        }
        binding.btnKonseling.setOnClickListener {
            comingSoon()
        }
    }

    private fun comingSoon(){
        Toast.makeText(requireContext(), getString(R.string.coming_soon), Toast.LENGTH_LONG).show()
    }
}