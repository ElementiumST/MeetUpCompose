package com.example.meetup.di

import android.content.Context
import com.example.meetup.data.local.SharedPrefsRepository
import com.example.meetup.data.local.SharedPrefsRepositoryImpl
import com.example.meetup.ui.app.App
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun bindContext(): Context {
        return App.instance!!
    }

    @Provides
    fun bindSharedPrefsRepository(
        context: Context
    ): SharedPrefsRepository {
        return SharedPrefsRepositoryImpl(context)
    }
}