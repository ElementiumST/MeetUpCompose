package com.example.meetup.data.api.auth

import com.example.meetup.data.model.auth.SignInSet
import com.example.meetup.data.model.auth.SignUpSet
import com.example.meetup.data.model.auth.TokenResponse

interface AuthRepository {
    fun signIn(signInSet: SignInSet) : TokenResponse

    fun singUp(singUpSet: SignUpSet) : TokenResponse

    fun updateToken(refreshToken: TokenResponse): TokenResponse
}