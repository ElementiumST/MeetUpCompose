package com.example.meetup.okhttp

import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// HARDCODE test api
class MeetUpRetrofitBuilder(
    private val httpLogger: HttpLoggingInterceptor,
    private val cache: Cache
): RetrofitBuilder {
    override fun build(): Retrofit {
        val builder = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
        return builder.client(
            getHttpClientBuilder()
                .addInterceptor(httpLogger)
                .cache(cache)
                .build()
        ).build()
    }

    private fun getHttpClientBuilder(): OkHttpClient.Builder = OkHttpClient.Builder()

    companion object {
        const val URL = "http://188.186.198.202/"
    }
}