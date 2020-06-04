package com.molleti.adressbook.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.molleti.adressbook.api.APIInterface
import com.molleti.adressbook.model.Person
import kotlinx.coroutines.launch

class PersonsViewModel(private val serverInterface: APIInterface) : ViewModel() {

    private val persons = MutableLiveData<Resource<List<Person>>>()

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            persons.postValue(Resource.progress(null))

            try {
                val peopleList = serverInterface.getPeople()
                if (peopleList.isEmpty()) {
                    persons.postValue(Resource.failed(null))
                } else {
                    persons.postValue(Resource.success(peopleList))
                }
            } catch (ex: Exception) {
                persons.postValue(Resource.failed(null))
            }
        }
    }

    fun getPeople(): LiveData<Resource<List<Person>>> = persons
}