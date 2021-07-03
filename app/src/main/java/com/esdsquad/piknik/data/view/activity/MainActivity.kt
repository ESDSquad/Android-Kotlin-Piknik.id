package com.esdsquad.piknik.data.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.esdsquad.piknik.data.view.adapter.OnboardingAdapter
import com.esdsquad.piknik.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupView()
        setupViewModel()
        setupListener()
        setupObserver()
    }

    private fun setupView() {
        val adapter = OnboardingAdapter(supportFragmentManager, lifecycle)
        binding.viewpager.adapter = adapter
        binding.dotsIndicator.setViewPager2(binding.viewpager)
    }

    private fun setupViewModel() {
        //TODO("Not yet implemented")
    }

    private fun setupListener() {
        //TODO("Not yet implemented")
    }

    private fun setupObserver() {
        //TODO("Not yet implemented")
    }
}