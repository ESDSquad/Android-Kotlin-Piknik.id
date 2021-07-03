package com.esdsquad.piknik.data.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.esdsquad.piknik.data.view.adapter.OnboardingAdapter
import com.esdsquad.piknik.databinding.ActivityOnboardingBinding

class OnboardingActivity : AppCompatActivity() {

    private val binding: ActivityOnboardingBinding by lazy {
        ActivityOnboardingBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupView()
        //setupViewModel()
    }

    private fun setupView() {
        val adapter = OnboardingAdapter(supportFragmentManager, lifecycle)
        binding.viewpager.adapter = adapter
        binding.dotsIndicator.setViewPager2(binding.viewpager)
    }

}