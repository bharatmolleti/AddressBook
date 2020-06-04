package com.molleti.adressbook.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.molleti.adressbook.api.APIInterface

class ViewModelFactory(private val apiInterface: APIInterface) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PersonsViewModel(apiInterface) as T
    }
}