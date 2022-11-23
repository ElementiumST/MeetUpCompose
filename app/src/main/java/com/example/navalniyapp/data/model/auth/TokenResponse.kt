package com.example.meetup.data.model.auth

data class TokenResponse(
    var accessToken: String = "",
    var refreshToken: String = ""
)


