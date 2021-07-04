package com.esdsquad.piknik.data.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.esdsquad.piknik.databinding.FragmentProvinceBinding

class ProvinceFragment : Fragment() {

    private lateinit var binding: FragmentProvinceBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProvinceBinding.inflate(inflater, container, false)
        return binding.root
    }

}