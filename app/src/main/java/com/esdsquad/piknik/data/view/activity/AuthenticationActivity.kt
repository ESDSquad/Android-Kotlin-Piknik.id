package com.esdsquad.piknik.data.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.esdsquad.piknik.data.viewmodel.AuthenticationViewModel
import com.esdsquad.piknik.data.viewmodel.factory.AuthenticationViewModelFactory
import com.esdsquad.piknik.databinding.ActivityAuthenticationBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class AuthenticationActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()
    private val authenticationViewModelFactory: AuthenticationViewModelFactory by instance()
    private val binding: ActivityAuthenticationBinding by lazy {
        ActivityAuthenticationBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupViewModel()
    }

    private fun setupViewModel() {
        ViewModelProvider(
            this,
            authenticationViewModelFactory
        ).get(AuthenticationViewModel::class.java)
    }
}