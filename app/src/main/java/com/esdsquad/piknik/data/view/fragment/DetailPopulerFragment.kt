package com.esdsquad.piknik.data.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.esdsquad.piknik.databinding.FragmentDetailPopulerBinding

class DetailPopulerFragment : Fragment() {

    private lateinit var binding: FragmentDetailPopulerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailPopulerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        binding.tvLayoutToolbar.tvToolbar.text = "Batu Kuda Manglayang"
        binding.tvLayoutToolbar.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}