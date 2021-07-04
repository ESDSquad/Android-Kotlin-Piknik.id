package com.esdsquad.piknik.data.view.fragment.bottomnav


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.esdsquad.piknik.R
import com.esdsquad.piknik.data.model.ArticelModel
import com.esdsquad.piknik.data.view.adapter.ArticelAdapter
import com.esdsquad.piknik.data.view.adapter.ImageSliderAdapter
import com.esdsquad.piknik.databinding.FragmentBerandaBinding


class BerandaFragment : Fragment() {

    private lateinit var binding: FragmentBerandaBinding
    var images = intArrayOf(
        R.drawable.iklan,
        R.drawable.iklan_1,
        R.drawable.iklan_2
    )

    private lateinit var adapter: ArticelAdapter

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
        setupRecycerView()
        setupViewModel()
        setupListener()
        setupObserver()
    }

    private fun setupRecycerView() {
        val listAdapter: ArrayList<ArticelModel> = ArrayList()
        listAdapter.add(
            ArticelModel(
                1,
                "PPKM Tahap Dua Kota Bandung Dimulai, Ini Daftar Perubahan Aturannya",
                "https://pict.sindonews.net/dyn/620/pena/news/2021/01/27/701/315478/ppkm-tahap-dua-kota-bandung-dimulai-ini-daftar-perubahan-aturannya-kmx.png"
            )
        )
        listAdapter.add(
            ArticelModel(
                2,
                "Aturan Lengkap PPKM Darurat di Jawa-Bali Selama 3-20 Juli",
                "https://akcdn.detik.net.id/visual/2021/06/23/jokowi_169.jpeg"
            )
        )
        listAdapter.add(
            ArticelModel(
                3,
                "Mengenal apa itu Staycation, Kamu harus coba konsep ini",
                "https://ik.imagekit.io/tvlk/blog/2020/01/Staycation-1-Pixabay.jpg"
            )
        )
        adapter = ArticelAdapter(listAdapter)
        binding.listArtikel.adapter = adapter
    }

    private fun setupView() {
        val adapter = ImageSliderAdapter(requireContext(), images)
        binding.viewpager.adapter = adapter
        binding.dotsIndicator.setViewPager(binding.viewpager)

        binding.tvLihatSemua.setOnClickListener {
            findNavController().navigate(R.id.action_berandaFragment_to_populerFragment)
        }

        binding.tvLokasi.setOnClickListener {
            findNavController().navigate(R.id.action_berandaFragment_to_provinceFragment)
        }

        binding.ivNimbrung.setOnClickListener {
            findNavController().navigate(R.id.action_berandaFragment_to_nimbrungFragment)
        }

        binding.tvNimbrung.setOnClickListener {
            findNavController().navigate(R.id.action_berandaFragment_to_nimbrungFragment)
        }
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