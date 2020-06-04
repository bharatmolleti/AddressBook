package com.molleti.adressbook.api

import com.molleti.adressbook.model.Person

interface APIInterface {

    suspend fun getPeople(): List<Person>

}