package com.molleti.adressbook.api

import com.molleti.adressbook.model.Person

class APIInterfaceImpl(private val retroInstance: RetrofitInterface) : APIInterface {
    override suspend fun getPeople(): List<Person> = retroInstance.getPeople()
}