package com.esdsquad.piknik.data.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.esdsquad.piknik.data.viewmodel.AuthenticationViewModel
import com.esdsquad.piknik.network.PiknikRepository

class AuthenticationViewModelFactory(
    private val repository: PiknikRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AuthenticationViewModel(repository) as T
    }
}