package com.esdsquad.piknik.data.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.esdsquad.piknik.network.PiknikRepository
import com.esdsquad.piknik.storage.perferences.OnboardingPreferencesModel

class OnboardingViewModel(
    private val repository: PiknikRepository
) : ViewModel() {
    val preferences: MutableLiveData<OnboardingPreferencesModel> = MutableLiveData()

    fun getPreferences() {
        preferences.value = repository.getPreferencesOnboarding()
    }

    fun savePrefFist(first: Boolean?) {
        repository.savePreferencesOnboarding(first)
    }
}