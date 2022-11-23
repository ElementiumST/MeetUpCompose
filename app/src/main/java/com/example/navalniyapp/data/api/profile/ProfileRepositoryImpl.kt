package com.example.meetup.data.api.profile

import com.example.meetup.data.api.MeetUpClient
import com.example.meetup.data.model.profile.ProfileResponse
import com.example.meetup.ui.util.dataOrException

class ProfileRepositoryImpl(
    private val meetUpClient: MeetUpClient
): ProfileRepository{
    override fun getProfileById(profileId: String): ProfileResponse {
        return meetUpClient.getProfileById(profileId).execute().dataOrException()
    }
}