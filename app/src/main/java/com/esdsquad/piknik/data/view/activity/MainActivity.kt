package com.esdsquad.piknik.data.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.esdsquad.piknik.R
import com.esdsquad.piknik.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupView()
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
}