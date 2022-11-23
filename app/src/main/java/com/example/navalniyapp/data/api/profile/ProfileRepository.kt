package com.example.meetup.data.api.profile

import com.example.meetup.data.model.profile.ProfileResponse

interface ProfileRepository {

    fun getProfileById(profileId: String): ProfileResponse
}