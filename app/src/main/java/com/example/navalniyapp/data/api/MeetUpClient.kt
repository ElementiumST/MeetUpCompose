package com.example.meetup.data.api

import com.example.meetup.data.model.auth.*
import com.example.meetup.data.model.profile.ProfileResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * Общий клиет для конеретного API
 */
interface MeetUpClient {

    @GET("profile/{profileId}")
    fun getProfileById(@Path("profileId") profileId: String): Call<ProfileResponse>

    @POST("signIn")
    fun signIn(@Body signInSet: SignInSet): Call<TokenResponse>

    @POST("signUp")
    fun signUp(@Body singUpSet: SignUpSet): Call<TokenResponse>

    @POST("refreshToken")
    fun updateToken(@Body tokenRefreshSet: TokenRefreshSet): Call<TokenResponse>
}