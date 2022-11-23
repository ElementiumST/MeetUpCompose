package com.example.meetup.data.local

import android.content.Context
import android.content.SharedPreferences
import com.example.meetup.data.model.auth.TokenResponse
import javax.inject.Inject

class SharedPrefsRepositoryImpl
@Inject constructor(context: Context) : SharedPrefsRepository {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    override fun setUserTokenSet(tokenResponse: TokenResponse) {
        sharedPreferences.edit()
            .putString(USER_REFRESH_TOKEN, tokenResponse.refreshToken)
            .putString(USER_ACCESS_TOKEN, tokenResponse.accessToken)
            .apply()
    }

    override fun setUserId(userId: String) {
        sharedPreferences.edit()
            .putString(USER_ID, userId)
            .apply()
    }

    override fun getUserId(): String? {
        return sharedPreferences.getString(USER_ID, null)
    }

    override fun getUserRefreshToken(): String? {
        return sharedPreferences.getString(USER_REFRESH_TOKEN, null)
    }

    override fun getUserAccessToken(): String? {
        return sharedPreferences.getString(USER_REFRESH_TOKEN, null)
    }


    companion object {
        const val USER_ID = "user_id"
        const val USER_REFRESH_TOKEN = "user_refresh_token"
        const val USER_ACCESS_TOKEN = "user_access_token"

        const val PREFS_NAME = "appdata"
    }
}
