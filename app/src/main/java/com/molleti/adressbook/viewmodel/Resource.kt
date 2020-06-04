package com.molleti.adressbook.viewmodel

data class Resource<out T>(val status: Status?, val data: T?, val message: String?) {

    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCESS, data, Status.SUCESS.toString())
        }

        fun <T> failed(data: T?): Resource<T> {
            return Resource(Status.FAILED, data, Status.FAILED.toString())
        }

        fun <T> progress(data: T?): Resource<T> {
            return Resource(Status.IN_PROGRESS, data, Status.IN_PROGRESS.toString())
        }
    }
}