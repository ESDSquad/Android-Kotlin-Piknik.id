package com.esdsquad.piknik.data.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.esdsquad.piknik.data.viewmodel.MainViewModel
import com.esdsquad.piknik.network.LokasiRepository
import com.esdsquad.piknik.network.PiknikRepository

class MainViewModelFactory(
    private val repositoryLokasi: LokasiRepository,
    private val repository: PiknikRepository,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repositoryLokasi, repository) as T
    }
}