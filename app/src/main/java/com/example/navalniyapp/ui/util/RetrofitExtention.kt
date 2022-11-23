package com.example.meetup.ui.util

import com.example.meetup.ui.util.model.RequestException
import retrofit2.Response

fun <T : Any> Response<T>.dataOrException(): T {
    if (this.isSuccessful) {
        return body()!!
    } else {
        throw RequestException("Request is not successful with code: ${code()}", code())
    }
}
