package com.example.meetup.ui.splash.model

sealed class LoadDataState {
    object Prepare: LoadDataState()
    object Fail: LoadDataState()
    data class Success(val username: String): LoadDataState()
}
