package com.example.timerapp.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ProfileViewModel(application: Application) : AndroidViewModel {
    private val readAllProfiles: Flow<List<Profile>>
    private val repository: ProfileRepository

    init {
        val profileDao = AppDatabase.getDatabase(application).profileDao()
        repository = ProfileRepository(profileDao)
        readAllProfiles = repository.readAllProfiles
    }

    fun addProfile(profile: Profile) {
        viewModelScope.launch ( Dispatchers.IO ) {
            repository.addProfile(profile)
        }
    }
}