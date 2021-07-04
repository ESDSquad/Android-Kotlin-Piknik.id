package com.esdsquad.piknik.data.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.esdsquad.piknik.databinding.AdapterListPopulerBinding
import com.esdsquad.piknik.network.response.TempatWisataResponse
import java.util.*
import kotlin.collections.ArrayList

class PopulerAdapter(
    var tempat: ArrayList<TempatWisataResponse.TempatWisataResponseItem>,
    var listener: OnAdapterListener
) : RecyclerView.Adapter<PopulerAdapter.ViewHolder>(), Filterable {

    private var tempatFilter = ArrayList<TempatWisataResponse.TempatWisataResponseItem>()

    init {
        tempatFilter = tempat
    }


    interface OnAdapterListener {
        fun onClick(result: ArrayList<TempatWisataResponse.TempatWisataResponseItem>)
    }

    class ViewHolder(val binding: AdapterListPopulerBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        AdapterListPopulerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tempats = tempat[position]
        holder.binding.tvWisata.text = tempats.nama
        holder.binding.tvAlamat.text = tempats.alamat
    }

    override fun getItemCount() = tempat.size

    fun setData(data: List<TempatWisataResponse.TempatWisataResponseItem>) {
        tempat.clear()
        tempat.addAll(data)
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val char = constraint.toString()
                if (char.isEmpty()) {
                    tempatFilter = tempat
                } else {
                    val tempatFiltered = ArrayList<TempatWisataResponse.TempatWisataResponseItem>()
                    for (tempat in tempat) {
                        if (tempat.nama!!.lowercase(Locale.getDefault())
                                .contains(char.lowercase(Locale.getDefault()))
                        ) {
                            tempatFiltered.add(tempat)
                        }
                    }
                    tempatFilter = tempatFiltered
                }
                val tempatResult = FilterResults()
                tempatResult.values = tempatFilter
                return tempatResult
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                tempatFilter =
                    results?.values as ArrayList<TempatWisataResponse.TempatWisataResponseItem>
                notifyDataSetChanged()
            }
        }
    }
}