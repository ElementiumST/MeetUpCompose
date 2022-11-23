package com.example.meetup.di

import com.example.meetup.data.api.MeetUpClient
import com.example.meetup.data.api.profile.ProfileRepository
import com.example.meetup.data.api.profile.ProfileRepositoryImpl
import com.example.meetup.data.local.SharedPrefsRepository
import com.example.meetup.domain.auth.GetUserDataUseCase
import com.example.meetup.domain.auth.GetUserDataUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ProfileModule {

    @Provides
    fun provideProfileRepository(
        meetUpClient: MeetUpClient
    ): ProfileRepository {
        return ProfileRepositoryImpl(meetUpClient)
    }

    @Provides
    fun provideGetUserFromLocalUseCase(
        sharedPrefsRepository: SharedPrefsRepository,
        profileRepository: ProfileRepository
    ): GetUserDataUseCase {
        return GetUserDataUseCaseImpl(
            sharedPrefsRepository,
            profileRepository
        )
    }

}