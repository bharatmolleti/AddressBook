package com.molleti.adressbook.api

import com.molleti.adressbook.model.Person
import retrofit2.http.GET

interface RetrofitInterface {

    @GET("people")
    suspend fun getPeople(): List<Person>
}