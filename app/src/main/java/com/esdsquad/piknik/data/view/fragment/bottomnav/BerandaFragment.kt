package com.esdsquad.piknik.data.view.fragment.bottomnav


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.esdsquad.piknik.R
import com.esdsquad.piknik.data.view.adapter.ImageSliderAdapter
import com.esdsquad.piknik.databinding.FragmentBerandaBinding


class BerandaFragment : Fragment() {

    private lateinit var binding: FragmentBerandaBinding
    var images = intArrayOf(
        R.drawable.iklan,
        R.drawable.iklan_1,
        R.drawable.iklan_2
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBerandaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupViewModel()
        setupListener()
        setupObserver()
    }

    private fun setupView() {
        val adapter = ImageSliderAdapter(requireContext(), images)
        binding.viewpager.adapter = adapter
        binding.dotsIndicator.setViewPager(binding.viewpager)
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