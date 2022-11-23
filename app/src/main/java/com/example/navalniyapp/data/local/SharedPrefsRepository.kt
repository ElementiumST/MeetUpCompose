package com.example.meetup.data.local

import com.example.meetup.data.model.auth.TokenResponse

interface SharedPrefsRepository {
    fun setUserTokenSet(tokenResponse: TokenResponse)

    fun setUserId(userId: String)

    fun getUserId(): String?

    fun getUserRefreshToken(): String?

    fun getUserAccessToken(): String?
}