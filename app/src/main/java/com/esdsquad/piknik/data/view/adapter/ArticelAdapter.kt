package com.esdsquad.piknik.data.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.esdsquad.piknik.data.model.ArticelModel
import com.esdsquad.piknik.databinding.AdapterListArtikelBinding

class ArticelAdapter(
    var articels: ArrayList<ArticelModel>
) : RecyclerView.Adapter<ArticelAdapter.ViewHolder>() {


    class ViewHolder(val binding: AdapterListArtikelBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        AdapterListArtikelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val new = articels[position]
        holder.binding.tvJudul.text = new.judul
        Glide.with(holder.binding.ivArtikel.context)
            .load(new.photo)
            .centerCrop()
            .into(holder.binding.ivArtikel)
    }

    override fun getItemCount() = articels.size

    fun setData(data: List<ArticelModel>) {
        articels.clear()
        articels.addAll(data)
        notifyDataSetChanged()
    }

}