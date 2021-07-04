package com.esdsquad.piknik.data.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.esdsquad.piknik.R
import com.esdsquad.piknik.data.viewmodel.AuthenticationViewModel
import com.esdsquad.piknik.data.viewmodel.MainViewModel
import com.esdsquad.piknik.data.viewmodel.factory.AuthenticationViewModelFactory
import com.esdsquad.piknik.data.viewmodel.factory.MainViewModelFactory
import com.esdsquad.piknik.databinding.ActivityMainBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override val kodein by kodein()
    private val authenticationViewModelFactory: AuthenticationViewModelFactory by instance()
    private val mainViewModelFactory: MainViewModelFactory by instance()
    private lateinit var viewModel: AuthenticationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupView()
        setupViewModel()
        setupListener()
        setupObserver()
    }

    private fun setupView() {
        val navController = findNavController(R.id.hostFragment)
        binding.navigationView.setupWithNavController(navController)

        binding.navigationView.setOnNavigationItemSelectedListener {
            val clearNavOptions =
                NavOptions.Builder().setLaunchSingleTop(true).setPopUpTo(R.id.main_navgraph, true)
                    .build()
            when (it.itemId) {
                R.id.navigation_beranda -> {
                    navController.navigate(R.id.berandaFragment, null, clearNavOptions)
                    true
                }
                R.id.navigation_pesanan -> {
                    navController.navigate(R.id.pesananFragment, null, clearNavOptions)
                    true
                }
                R.id.navigation_notifikasi -> {
                    navController.navigate(R.id.notifikasiFragment, null, clearNavOptions)
                    true
                }
                R.id.navigation_akun -> {
                    navController.navigate(R.id.akunSayaFragment, null, clearNavOptions)
                    true
                }
                else -> false
            }
        }
        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.navigationView.isVisible = when (destination.id) {
                R.id.berandaFragment -> true
                R.id.pesananFragment -> true
                R.id.notifikasiFragment -> true
                R.id.akunSayaFragment -> true
                else -> false
            }
        }
    }

    private fun setupViewModel() {
        viewModel =
            ViewModelProvider(
                this,
                authenticationViewModelFactory
            ).get(AuthenticationViewModel::class.java)

        ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java)
    }

    private fun setupListener() {
        viewModel.getPreferencesToken()
    }

    private fun setupObserver() {
        viewModel.preferencesToken.observe(this, Observer {
            if (it.token.isNullOrBlank()) {
                startActivity(
                    Intent(
                        this@MainActivity,
                        AuthenticationActivity::class.java
                    )
                )
                finish()
            }
        })
    }
}