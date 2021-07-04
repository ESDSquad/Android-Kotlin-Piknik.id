package com.esdsquad.piknik.data.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.esdsquad.piknik.data.model.RiwayatModel
import com.esdsquad.piknik.data.view.adapter.RiwayatAdapter
import com.esdsquad.piknik.databinding.FragmentRiwayatBinding

class RiwayatFragment : Fragment() {

    private lateinit var binding: FragmentRiwayatBinding
    private lateinit var adapter: RiwayatAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRiwayatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        val listAdapter: ArrayList<RiwayatModel> = ArrayList()
        listAdapter.add(
            RiwayatModel(
                1,
                "2 Juli 2021",
                "No. Pesanan PIK14045",
                "Rp120.000",
                "Batu Kuda Manglayang"
            )
        )
        listAdapter.add(
            RiwayatModel(
                2,
                "28 Februari 2021",
                "No. Pesanan PIK15425",
                "Rp160.000",
                "Citere Camping Ground"
            )
        )
        listAdapter.add(
            RiwayatModel(
                3,
                "21 Februari 2021",
                "No. Pesanan PIK14435",
                "Rp110.000",
                "Kampung Bamboo"
            )
        )
        listAdapter.add(
            RiwayatModel(
                4,
                "10 Januari 2021",
                "No. Pesanan PIK11468",
                "Rp130.000",
                "Turangga Outbond & Camp"
            )
        )
        listAdapter.add(
            RiwayatModel(
                5,
                "1 Januari 2021",
                "No. Pesanan PIK1754",
                "Rp190.000",
                "Rancauppas Campground"
            )
        )

        adapter = RiwayatAdapter(listAdapter)
        binding.listArtikel.adapter = adapter
    }

}