package com.esdsquad.piknik.data.view.fragment.bottomnav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.esdsquad.piknik.databinding.FragmentAkunSayaBinding

class AkunSayaFragment : Fragment() {

    private lateinit var binding: FragmentAkunSayaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAkunSayaBinding.inflate(inflater, container, false)
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
        //TODO("Not yet implemented")
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