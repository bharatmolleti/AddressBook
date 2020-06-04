package com.molleti.adressbook.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.molleti.adressbook.api.APIInterface
import kotlinx.coroutines.launch

class PersonsViewModel(private val serverInterface: APIInterface) : ViewModel() {

    private fun fetchData() {
        viewModelScope.launch {

        }
    }


}