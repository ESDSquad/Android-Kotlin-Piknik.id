package com.esdsquad.piknik.data.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.esdsquad.piknik.data.view.adapter.OnboardingAdapter
import com.esdsquad.piknik.data.viewmodel.OnboardingViewModel
import com.esdsquad.piknik.data.viewmodel.factory.OnboardingViewModelFactory
import com.esdsquad.piknik.databinding.ActivityOnboardingBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class OnboardingActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()
    private val onboardingViewModelFactory: OnboardingViewModelFactory by instance()
    private lateinit var viewModel: OnboardingViewModel

    private val binding: ActivityOnboardingBinding by lazy {
        ActivityOnboardingBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupView()
        setupViewModelAndSetPref()
    }


    private fun setupView() {
        val adapter = OnboardingAdapter(supportFragmentManager, lifecycle)
        binding.viewpager.adapter = adapter
        binding.dotsIndicator.setViewPager2(binding.viewpager)

    }

    private fun setupViewModelAndSetPref() {
        viewModel =
            ViewModelProvider(this, onboardingViewModelFactory).get(OnboardingViewModel::class.java)
        binding.tvSkip.setOnClickListener {
            startActivity(
                Intent(
                    this@OnboardingActivity,
                    MainActivity::class.java
                )
            )
            viewModel.savePrefFist(false)
            finish()
        }
    }
}