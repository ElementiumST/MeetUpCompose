package com.example.meetup.domain.auth

import com.example.meetup.data.model.profile.ProfileResponse

interface GetUserDataUseCase {
    fun execute(): ProfileResponse
}