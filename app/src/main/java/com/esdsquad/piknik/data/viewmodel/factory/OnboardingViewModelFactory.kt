package com.esdsquad.piknik.data.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.esdsquad.piknik.data.viewmodel.ExampleViewModel
import com.esdsquad.piknik.network.PiknikRepository

class OnboardingViewModelFactory(
    private val repository: PiknikRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ExampleViewModel(repository) as T
    }
}