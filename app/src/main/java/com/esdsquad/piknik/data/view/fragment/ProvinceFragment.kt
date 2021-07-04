package com.esdsquad.piknik.data.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.esdsquad.piknik.R
import com.esdsquad.piknik.data.view.adapter.ProvinceAdapter
import com.esdsquad.piknik.data.viewmodel.MainViewModel
import com.esdsquad.piknik.databinding.FragmentProvinceBinding
import com.esdsquad.piknik.network.Resource
import com.esdsquad.piknik.network.response.ProvinsiResponse
import com.esdsquad.piknik.utils.showToast
import timber.log.Timber

class ProvinceFragment : Fragment() {

    private val viewModel by lazy { ViewModelProvider(requireActivity()).get(MainViewModel::class.java) }
    private lateinit var binding: FragmentProvinceBinding
    private lateinit var provinceAdapter: ProvinceAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProvinceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListener()
        setupRecyclerView()
        setupObserver()
    }

    private fun setupListener() {
        viewModel.fetchProvinsi()
        binding.editSearch.doAfterTextChanged {
            provinceAdapter.filter.filter(it.toString())
        }
        binding.refreshProvince.setOnRefreshListener {
            viewModel.fetchProvinsi()
        }
    }

    private fun setupRecyclerView() {
        provinceAdapter =
            ProvinceAdapter(arrayListOf(), object : ProvinceAdapter.OnAdapterListener {
                override fun onClick(result: ArrayList<ProvinsiResponse.ProvinsiItem>) {
                    viewModel.fetchProvinsi()
                    findNavController().navigate(
                        R.id.action_provinceFragment_to_cityFragment
                    )
                }
            })
        binding.listProvince.adapter = provinceAdapter
    }

    private fun setupObserver() {
        viewModel.provinsiResponse.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Loading -> {
                    Timber.e("data : loading")
                    binding.refreshProvince.isRefreshing = true
                }
                is Resource.Success -> {
                    binding.refreshProvince.isRefreshing = false
                    Timber.e("data : ${it.data!!.provinsi}")
                    provinceAdapter.setData(it.data.provinsi!! as List<ProvinsiResponse.ProvinsiItem>)
                }
                is Resource.Error -> {
                    binding.refreshProvince.isRefreshing = false
                    showToast("Lengkapi data pencarian")
                }
            }
        })
    }

}