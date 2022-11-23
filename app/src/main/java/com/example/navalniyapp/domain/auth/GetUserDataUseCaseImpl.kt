package com.example.meetup.domain.auth

import com.example.meetup.data.api.profile.ProfileRepository
import com.example.meetup.data.local.SharedPrefsRepository
import com.example.meetup.data.model.profile.ProfileResponse
import com.example.meetup.data.model.profile.exception.ProfileNotFoundException
import com.example.meetup.ui.util.model.RequestException

class GetUserDataUseCaseImpl(
    private val sharedPrefsRepository: SharedPrefsRepository,
    private val profileRepository: ProfileRepository
): GetUserDataUseCase {
    override fun execute(): ProfileResponse {
        val userId = sharedPrefsRepository.getUserId() ?: throw ProfileNotFoundException()
        try {
            return profileRepository.getProfileById(userId)
        } catch (exception: Exception) {
            if (exception is RequestException && exception.code == 404) {
                throw ProfileNotFoundException()
            } else {
                throw exception
            }
        }
    }

}