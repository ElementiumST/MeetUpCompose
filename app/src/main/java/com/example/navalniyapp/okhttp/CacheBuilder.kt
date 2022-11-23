package com.example.meetup.okhttp

import okhttp3.Cache

interface CacheBuilder {
    fun build(): Cache
}