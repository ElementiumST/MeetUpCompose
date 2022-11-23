package com.example.meetup.data.api.auth

import com.example.meetup.data.api.MeetUpClient
import com.example.meetup.data.model.auth.SignInSet
import com.example.meetup.data.model.auth.SignUpSet
import com.example.meetup.data.model.auth.TokenRefreshSet
import com.example.meetup.data.model.auth.TokenResponse
import com.example.meetup.ui.util.dataOrException
import javax.inject.Inject

class AuthRepositoryImpl
@Inject constructor(
    private val meetUpClient: MeetUpClient
) : AuthRepository {
    override fun signIn(signInSet: SignInSet): TokenResponse {
        return meetUpClient.signIn(signInSet).execute().dataOrException()
    }

    override fun singUp(singUpSet: SignUpSet): TokenResponse {
        return meetUpClient.signUp(singUpSet).execute().dataOrException()
    }

    override fun updateToken(refreshToken: TokenResponse): TokenResponse {
        val tokenRefreshSet = TokenRefreshSet(refreshToken.refreshToken)
        return meetUpClient.updateToken(tokenRefreshSet).execute().dataOrException()
    }
}