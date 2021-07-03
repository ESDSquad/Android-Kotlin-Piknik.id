package com.esdsquad.piknik.data.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esdsquad.piknik.network.ExampleRepository
import com.esdsquad.piknik.network.Resource
import com.esdsquad.piknik.network.response.ExampleResponse
import kotlinx.coroutines.launch

class ExampleViewModel(
    private val repository: ExampleRepository
) : ViewModel() {

    val exampleResponse: MutableLiveData<Resource<ExampleResponse>> = MutableLiveData()

    fun fetchExampleGet() = viewModelScope.launch {
        exampleResponse.value = Resource.Loading()
        try {
            val response = repository.fetchGet()
            exampleResponse.value = Resource.Success(response.body()!!)
        } catch (e: Exception) {
            exampleResponse.value = Resource.Error(e.message.toString())
        }
    }

    fun fetchExamplePost() = viewModelScope.launch {
        exampleResponse.value = Resource.Loading()
        try {
            val response = repository.fetchPost()
            exampleResponse.value = Resource.Success(response.body()!!)
        } catch (e: Exception) {
            exampleResponse.value = Resource.Error(e.message.toString())
        }
    }
}