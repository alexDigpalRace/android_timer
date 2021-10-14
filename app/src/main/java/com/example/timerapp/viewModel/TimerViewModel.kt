package com.example.timerapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timerapp.data.AppDatabase
import com.example.timerapp.model.Timer
import com.example.timerapp.repos.TimerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TimerViewModel(application: Application) : AndroidViewModel(application) {
    var readAllTimers : List<Timer> = emptyList()
    var readTimer : Timer = Timer()
    private val repository: TimerRepository

    init {
        val timerDao = AppDatabase.getDatabase(application).timerDao()
        repository = TimerRepository(timerDao)
    }

    fun getTimers(profileId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            readAllTimers = repository.getTimers(profileId)
        }
    }

}