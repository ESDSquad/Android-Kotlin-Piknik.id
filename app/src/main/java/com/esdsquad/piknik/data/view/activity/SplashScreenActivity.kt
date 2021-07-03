package com.esdsquad.piknik.data.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.esdsquad.piknik.data.viewmodel.OnboardingViewModel
import com.esdsquad.piknik.data.viewmodel.factory.OnboardingViewModelFactory
import com.esdsquad.piknik.databinding.ActivitySplashScreenBinding
import kotlinx.coroutines.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class SplashScreenActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()
    private val onboardingViewModelFactory: OnboardingViewModelFactory by instance()
    private lateinit var viewModel: OnboardingViewModel

    private val activityScope = CoroutineScope(Dispatchers.Main)
    private val binding: ActivitySplashScreenBinding by lazy {
        ActivitySplashScreenBinding.inflate(
            layoutInflater
        )
    }

    private val moveToMainActivity: Intent by lazy {
        Intent(
            this@SplashScreenActivity,
            MainActivity::class.java
        )
    }
    private val moveToOnboardingActivity: Intent by lazy {
        Intent(
            this@SplashScreenActivity,
            OnboardingActivity::class.java
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupViewModel()
        setupListener()
        setupObserver()
    }


    private fun delayOnboarding() {
        activityScope.launch {
            delay(3000)

            startActivity(moveToOnboardingActivity)
            finish()
        }
    }

    private fun delayMain() {
        activityScope.launch {
            delay(3000)

            startActivity(moveToMainActivity)
            finish()
        }
    }

    @Suppress("DEPRECATION")
    override fun onResume() {
        super.onResume()
        window.decorView.apply {
            systemUiVisibility =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }
    }

    override fun onPause() {
        activityScope.cancel()
        super.onPause()
    }

    private fun setupViewModel() {
        viewModel =
            ViewModelProvider(this, onboardingViewModelFactory).get(OnboardingViewModel::class.java)
    }

    private fun setupListener() {
        viewModel.getPreferences()
    }

    private fun setupObserver() {
        viewModel.preferences.observe(this, Observer {
            when (it.firstTime) {
                true -> delayOnboarding()
                false -> delayMain()
            }
        })
    }
}