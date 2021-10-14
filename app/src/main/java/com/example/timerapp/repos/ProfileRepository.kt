package com.example.timerapp.repos

import androidx.lifecycle.LiveData
import com.example.timerapp.dao.ProfileDao
import com.example.timerapp.model.Profile

class ProfileRepository (private val profileDao: ProfileDao) {
    val readAllProfiles: LiveData<List<Profile>> = profileDao.getProfiles()

    suspend fun addProfile(profile: Profile){
        profileDao.addProfile(profile)
    }

    suspend fun updateProfile(profile: Profile) {
        profileDao.updateProfile(profile)
    }

    suspend fun deleteProfile(profile: Profile) {
        profileDao.deleteProfile(profile)
    }
}