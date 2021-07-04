package com.esdsquad.piknik.data.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.esdsquad.piknik.R
import com.esdsquad.piknik.databinding.FragmentPopulerBinding


class PopulerFragment : Fragment() {

    private lateinit var binding: FragmentPopulerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPopulerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        binding.tvLayoutToolbar.tvToolbar.text = "Populer di Bandung"
        binding.tvLayoutToolbar.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }
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
    override fun onDestroy() {
        super.onDestroy()
        val window = requireActivity().window
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = requireActivity().resources.getColor(R.color.colorLight)

        val view = window.decorView
        view.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }

}