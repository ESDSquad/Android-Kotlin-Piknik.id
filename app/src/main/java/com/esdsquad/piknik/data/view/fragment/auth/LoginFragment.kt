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
import com.esdsquad.piknik.R
import com.esdsquad.piknik.data.view.activity.MainActivity
import com.esdsquad.piknik.data.viewmodel.AuthenticationViewModel
import com.esdsquad.piknik.databinding.FragmentLoginBinding
import com.esdsquad.piknik.network.Resource
import com.esdsquad.piknik.utils.showToast

class LoginFragment : Fragment() {

    private val viewModel by lazy { ViewModelProvider(requireActivity()).get(AuthenticationViewModel::class.java) }
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupObserver()
    }

    private fun setupView() {
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text
            val password = binding.etPassword.text
            when {
                email.isNullOrBlank() -> showToast("Email harus di isi")
                password.isNullOrBlank() -> showToast("Password harus di isi")
                else -> {
                    viewModel.login(email.toString(), password.toString())
                }
            }
        }
        binding.tvBuat.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    private fun setupObserver() {
        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
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