package com.example.meetup.data.model.profile

import com.example.meetup.data.model.auth.Position

data class ProfileResponse(
    val userId: String,
    val nickname: String,
    val location: Position,
)