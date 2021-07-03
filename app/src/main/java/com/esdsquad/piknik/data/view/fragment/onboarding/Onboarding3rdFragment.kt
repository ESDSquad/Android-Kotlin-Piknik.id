package com.esdsquad.piknik.data.view.fragment.onboarding

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.esdsquad.piknik.data.view.activity.MainActivity
import com.esdsquad.piknik.databinding.FragmentOnboarding3rdBinding

class Onboarding3rdFragment : Fragment() {

    private lateinit var binding: FragmentOnboarding3rdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboarding3rdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        binding.tvNext.setOnClickListener {
            startActivity(
                Intent(
                    requireActivity(),
                    MainActivity::class.java
                )
            )
            requireActivity().finish()
        }
    }

}