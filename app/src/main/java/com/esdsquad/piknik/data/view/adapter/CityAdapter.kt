package com.esdsquad.piknik.data.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.esdsquad.piknik.databinding.AdapterListCityBinding
import com.esdsquad.piknik.network.response.KotaResponse
import java.util.*
import kotlin.collections.ArrayList

class CityAdapter(
    var kota: ArrayList<KotaResponse.KotaKabupatenItem>,
    var listener: OnAdapterListener
) : RecyclerView.Adapter<CityAdapter.ViewHolder>(), Filterable {

    private var kotaFilter = ArrayList<KotaResponse.KotaKabupatenItem>()

    init {
        kotaFilter = kota
    }


    interface OnAdapterListener {
        fun onClick(result: ArrayList<KotaResponse.KotaKabupatenItem>)
    }

    class ViewHolder(val binding: AdapterListCityBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        AdapterListCityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val kotas = kota[position]
        holder.binding.textName.text = kotas.nama
    }

    override fun getItemCount() = kota.size

    fun setData(data: List<KotaResponse.KotaKabupatenItem>) {
        kota.clear()
        kota.addAll(data)
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val char = constraint.toString()
                if (char.isEmpty()) {
                    kotaFilter = kota
                } else {
                    val kotaFiltered = ArrayList<KotaResponse.KotaKabupatenItem>()
                    for (kota in kota) {
                        if (kota.nama!!.lowercase(Locale.getDefault())
                                .contains(char.lowercase(Locale.getDefault()))
                        ) {
                            kotaFiltered.add(kota)
                        }
                    }
                    kotaFilter = kotaFiltered
                }
                val kotaResult = FilterResults()
                kotaResult.values = kotaFilter
                return kotaResult
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                kotaFilter = results?.values as ArrayList<KotaResponse.KotaKabupatenItem>
                notifyDataSetChanged()
            }
        }
    }
}