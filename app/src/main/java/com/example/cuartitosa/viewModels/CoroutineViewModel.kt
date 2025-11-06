package com.example.cuartitosa.viewModels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoroutineViewModel: ViewModel() {
    val result = mutableStateOf("")
    val isLoading = mutableStateOf(false)

    fun callToApi() {
        viewModelScope.launch{
            call()
        }
    }

    suspend fun call() {
        isLoading.value = true
        result.value = withContext(Dispatchers.IO) {
            delay(5000)
            "Result"
        }
        isLoading.value = false
    }

    fun block() {
        Thread.sleep(10000)
    }
}