package com.esdsquad.piknik.data.view.fragment.bottomnav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.esdsquad.piknik.R
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
        binding.tvLayoutToolbar.tvToolbar.text = "Akun Saya"
    }

    @Suppress("DEPRECATION")
    override fun onStart() {
        super.onStart()
        val window = requireActivity().window
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = requireActivity().resources.getColor(R.color.colorPrimary)

        val view = window.decorView
        view.systemUiVisibility = 0
    }

    @Suppress("DEPRECATION")
    override fun onPause() {
        super.onPause()
        val window = requireActivity().window
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = requireActivity().resources.getColor(R.color.colorLight)

        val view = window.decorView
        view.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
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