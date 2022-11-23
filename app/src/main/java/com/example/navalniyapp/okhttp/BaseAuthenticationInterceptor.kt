package com.example.meetup.okhttp

import com.example.meetup.data.local.SharedPrefsRepository
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route

class BaseAuthenticationInterceptor(
    private val sharedPrefsRepository: SharedPrefsRepository
): Authenticator {
    override fun authenticate(route: Route?, response: Response): Request? {
        if (sharedPrefsRepository.getUserAccessToken() == null) {
            return null
        }

        //TODO Обработка стека запросов


        // Синхронизация для обработки ситуации при 2х параллельных запросов на аунтентификацию
        synchronized(this) {
            if (response.request.header(AUTHORIZATION_HEADER) != null) {
                val currentRefreshToken = sharedPrefsRepository.getUserRefreshToken()
                if (currentRefreshToken == null || currentRefreshToken.isEmpty()) {
                    return null
                }

                return response.request
                    .newBuilder()
                    .header(AUTHORIZATION_HEADER, parseToken(currentRefreshToken))
                    .build()
            }
        }
        return null
    }

    private fun parseToken(token: String): String {
        return "Bearer $token"
    }

    companion object {
        const val AUTHORIZATION_HEADER = "Authorization"
    }
}