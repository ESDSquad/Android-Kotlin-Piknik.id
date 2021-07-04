package com.esdsquad.piknik.data.view.fragment.auth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.esdsquad.piknik.data.view.activity.MainActivity
import com.esdsquad.piknik.data.viewmodel.AuthenticationViewModel
import com.esdsquad.piknik.databinding.FragmentRegisterBinding
import com.esdsquad.piknik.network.Resource
import com.esdsquad.piknik.utils.showToast

class RegisterFragment : Fragment() {

    private val viewModel by lazy { ViewModelProvider(requireActivity()).get(AuthenticationViewModel::class.java) }
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
        setupObserver()
    }

    private fun setupView() {
        binding.btnRegister.setOnClickListener {
            val namaLengkap = binding.etNama.text
            val email = binding.etEmail.text
            val password = binding.etPassword.text
            val passwords = binding.etPasswordKonfirmasi.text
            when {
                namaLengkap.isNullOrBlank() -> showToast("Nama lengkap harus di isi")
                email.isNullOrBlank() -> showToast("Email harus di isi")
                password.isNullOrBlank() -> showToast("Password harus di isi")
                passwords.isNullOrBlank() -> showToast("Password konfirmasi harus di isi")
                else -> {
                    if ((password.toString().equals(passwords.toString()))) {
                        viewModel.register(
                            namaLengkap.toString(),
                            email.toString(),
                            password.toString(),
                            passwords.toString()
                        )
                    } else {
                        showToast("Kombinasi password tidak sama")
                    }

                }
            }
        }
        binding.tvMasuk.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setupObserver() {
        viewModel.registerResponse.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    startActivity(
                        Intent(
                            requireContext(),
                            MainActivity::class.java
                        )
                    )
                    requireActivity().finish()
                }
                is Resource.Error -> {
                    Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

}