package com.esdsquad.piknik.data.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.esdsquad.piknik.network.PiknikRepository
import com.esdsquad.piknik.storage.perferences.PreferencesModel

class OnboardingViewModel(
    private val repository: PiknikRepository
) : ViewModel() {
    val preferences: MutableLiveData<List<PreferencesModel>> = MutableLiveData()
}