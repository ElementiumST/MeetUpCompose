package com.example.meetup.okhttp

import retrofit2.Retrofit

interface RetrofitBuilder {
    fun build(): Retrofit
}