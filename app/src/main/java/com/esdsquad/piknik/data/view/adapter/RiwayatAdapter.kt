package com.esdsquad.piknik.data.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.esdsquad.piknik.data.model.RiwayatModel
import com.esdsquad.piknik.databinding.AdapterListRiwayatBinding

class RiwayatAdapter(
    var riwayats: ArrayList<RiwayatModel>
) : RecyclerView.Adapter<RiwayatAdapter.ViewHolder>() {


    class ViewHolder(val binding: AdapterListRiwayatBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        AdapterListRiwayatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val riwayat = riwayats[position]
        holder.binding.tvTanggal.text = riwayat.tanggal
        holder.binding.tvNoPesanan.text = riwayat.no_pesanan
        holder.binding.tvHarga.text = riwayat.harga
        holder.binding.tvTempat.text = riwayat.wisata

    }

    override fun getItemCount() = riwayats.size

    fun setData(data: List<RiwayatModel>) {
        riwayats.clear()
        riwayats.addAll(data)
        notifyDataSetChanged()
    }

}