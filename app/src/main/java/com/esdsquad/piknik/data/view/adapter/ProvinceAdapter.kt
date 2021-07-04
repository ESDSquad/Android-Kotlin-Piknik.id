package com.esdsquad.piknik.data.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.esdsquad.piknik.databinding.AdapterListProvinceBinding
import com.esdsquad.piknik.network.response.ProvinsiResponse
import java.util.*
import kotlin.collections.ArrayList

class ProvinceAdapter(
    var provinsi: ArrayList<ProvinsiResponse.ProvinsiItem>,
    var listener: OnAdapterListener
) : RecyclerView.Adapter<ProvinceAdapter.ViewHolder>(), Filterable {

    private var provinsiFilter = ArrayList<ProvinsiResponse.ProvinsiItem>()

    init {
        provinsiFilter = provinsi
    }


    interface OnAdapterListener {
        fun onClick(result: ArrayList<ProvinsiResponse.ProvinsiItem>)
    }

    class ViewHolder(val binding: AdapterListProvinceBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        AdapterListProvinceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val provinsis = provinsi[position]
        holder.binding.textName.text = provinsis.nama
    }

    override fun getItemCount() = provinsi.size

    fun setData(data: List<ProvinsiResponse.ProvinsiItem>) {
        provinsi.clear()
        provinsi.addAll(data)
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val char = constraint.toString()
                if (char.isEmpty()) {
                    provinsiFilter = provinsi
                } else {
                    val provinsiFiltered = ArrayList<ProvinsiResponse.ProvinsiItem>()
                    for (provinsi in provinsi) {
                        if (provinsi.nama!!.lowercase(Locale.getDefault())
                                .contains(char.lowercase(Locale.getDefault()))
                        ) {
                            provinsiFiltered.add(provinsi)
                        }
                    }
                    provinsiFilter = provinsiFiltered
                }
                val provinsiResult = FilterResults()
                provinsiResult.values = provinsiFilter
                return provinsiResult
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                provinsiFilter = results?.values as ArrayList<ProvinsiResponse.ProvinsiItem>
                notifyDataSetChanged()
            }
        }
    }
}