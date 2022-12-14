package com.example.meetup.ui.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {
    init {
        instance = this
    }
    companion object {
        var instance: App? = null
    }
}