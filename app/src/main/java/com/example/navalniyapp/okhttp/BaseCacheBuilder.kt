package com.example.meetup.okhttp

import android.content.Context
import okhttp3.Cache
import java.io.File

class BaseCacheBuilder(
    private val context: Context
): CacheBuilder {

    override fun build(): Cache {
        return Cache(getCacheDir(), cacheSize)
    }

    private fun getCacheDir(): File = context.cacheDir

    companion object {
        // 30mb cache
        const val cacheSize: Long = 30 * 1024 * 1024
    }
}