package com.esdsquad.piknik.data.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.esdsquad.piknik.data.viewmodel.ExampleViewModel
import com.esdsquad.piknik.network.ExampleRepository

class ExampleViewModelFactory(
    private val repository: ExampleRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ExampleViewModel(repository) as T
    }
}