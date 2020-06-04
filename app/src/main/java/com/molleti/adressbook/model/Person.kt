package com.molleti.adressbook.model

data class Person(
    val id: Int = 0,
    val name: String = "",
    val phoneNo: String = "",
    val emailId: String?,
    val avatar: String?
)
