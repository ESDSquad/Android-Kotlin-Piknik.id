package com.esdsquad.piknik.data.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.esdsquad.piknik.R
import com.esdsquad.piknik.databinding.FragmentDetailPemesananBinding
import com.esdsquad.piknik.databinding.FragmentDetailPopulerBinding

class DetailPemesananFragment : Fragment() {

    private lateinit var binding:FragmentDetailPemesananBinding


        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
            binding = FragmentDetailPemesananBinding.inflate(inflater, container, false)
            return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()

    }

    private fun setupView() {
        binding.tvLayoutToolbar.tvToolbar.text = "DetailPemesanan"
        binding.tvLayoutToolbar.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}