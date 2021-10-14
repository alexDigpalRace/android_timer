package com.example.timerapp.repos

import com.example.timerapp.dao.TimerDao
import com.example.timerapp.model.Timer

class TimerRepository(private val timerDao: TimerDao) {
    suspend fun getTimers(profileId: Int) : List<Timer> {
        return timerDao.getTimers(profileId)
    }

    suspend fun getTimer(name: String, profileId: Int) : Timer {
        return timerDao.getTimer(name, profileId)
    }

    suspend fun insertTimer(timer: Timer) {
        timerDao.insertTimer(timer)
    }

    suspend fun updateTimer(timer: Timer) {
        timerDao.updateTimer(timer)
    }

    suspend fun deleteTimer(timer: Timer) {
        timerDao.deleteTimer(timer)
    }
}