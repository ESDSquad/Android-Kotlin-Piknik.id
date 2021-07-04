package com.esdsquad.piknik.data.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.esdsquad.piknik.data.viewmodel.MainViewModel
import com.esdsquad.piknik.network.LokasiRepository

class MainViewModelFactory(
    private val repository: LokasiRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}