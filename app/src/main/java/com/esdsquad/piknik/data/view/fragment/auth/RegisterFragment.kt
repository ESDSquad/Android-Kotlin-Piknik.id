package com.esdsquad.piknik.data.view.fragment.auth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.esdsquad.piknik.data.view.activity.MainActivity
import com.esdsquad.piknik.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        binding.btnRegister.setOnClickListener {
            startActivity(
                Intent(
                    requireContext(),
                    MainActivity::class.java
                )
            )
            requireActivity().finish()

        }
        binding.tvMasuk.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}