package com.example.meetup.ui.splash.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meetup.data.model.profile.exception.ProfileNotFoundException
import com.example.meetup.domain.auth.GetUserDataUseCase
import com.example.meetup.ui.splash.model.LoadDataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoadViewModel @Inject constructor(
    private val getUserDataUseCase: GetUserDataUseCase
) : ViewModel() {
    private val exceptionHandler by lazy { createExceptionHandler() }

    private val loadDataState = mutableStateOf<LoadDataState>(LoadDataState.Prepare)

    fun uploadData() {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {

            runCatching {
                val response = getUserDataUseCase.execute()
                loadDataState.value = LoadDataState.Success(response.nickname)
            }.onFailure { throwable ->
                if (throwable is ProfileNotFoundException) {
                    loadDataState.value = LoadDataState.Fail
                } else {
                    throw throwable
                }
            }
        }
    }

    private fun createExceptionHandler() = CoroutineExceptionHandler { _, throwable ->
        Log.e(TAG, "notHandledException", throwable)
    }

    companion object {
        const val TAG = "LoadViewModel"
    }
}