package com.example.timerapp.database

import kotlinx.coroutines.flow.Flow

class ProfileRepository (private val profileDao: ProfileDao) {
    val readAllProfiles: Flow<List<Profile>> = profileDao.getProfiles()

    suspend fun addProfile(profile: Profile){
        profileDao.addProfile(profile)
    }
}