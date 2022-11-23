package com.example.meetup.ui.util.model

class RequestException(
    message: String,
    val code: Int
    ): Exception(message) {
}