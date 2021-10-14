package com.example.timerapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.timerapp.data.AppDatabase
import com.example.timerapp.model.Profile
import com.example.timerapp.repos.ProfileRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileViewModel(application: Application) : AndroidViewModel(application) {
    val readAllProfiles: LiveData<List<Profile>>
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

    fun updateProfile(profile: Profile) {
        viewModelScope.launch ( Dispatchers.IO ) {
            repository.updateProfile(profile)
        }
    }

    fun deleteProfile(profile: Profile) {
        viewModelScope.launch (Dispatchers.IO) {
            repository.deleteProfile(profile)
        }
    }
}