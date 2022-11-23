package com.example.meetup.di

import android.content.Context
import com.example.meetup.data.api.MeetUpClient
import com.example.meetup.data.local.SharedPrefsRepository
import com.example.meetup.okhttp.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Authenticator
import okhttp3.Cache
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    fun provideMeetUpClient(
        retrofit: Retrofit
    ): MeetUpClient {
        return retrofit.create(MeetUpClient::class.java)
    }

    @Provides
    fun provideRetrofitClient(
        retrofitBuilder: RetrofitBuilder
    ): Retrofit {
        return retrofitBuilder.build()
    }

    @Provides
    fun provideRetrofitBuilder(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        cache: Cache
    ): RetrofitBuilder {
        return MeetUpRetrofitBuilder(
            httpLoggingInterceptor,
            cache
        )
    }

    @Provides
    fun provideHttpLogger(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BASIC)
        }
    }

    @Provides
    fun provideCache(
        cacheBuilder: CacheBuilder
    ): Cache {
        return cacheBuilder.build()
    }

    @Provides
    fun provideCacheBuilder(
        context: Context
    ): CacheBuilder {
        return BaseCacheBuilder(
            context
        )
    }

    @Provides
    fun provideAuthenticatorInterceptor(
        sharedPrefsRepository: SharedPrefsRepository
    ) : Authenticator {
        return BaseAuthenticationInterceptor(sharedPrefsRepository)
    }
}