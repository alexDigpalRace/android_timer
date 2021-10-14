package com.example.timerapp.dao

import androidx.room.*
import com.example.timerapp.model.Timer

@Dao
interface TimerDao {
    // get all Timers with a profile
    @Query("SELECT * FROM timers WHERE profile = :profileId")
    suspend fun getTimers(profileId: Int) : List<Timer>

    // get a Timer with a profile
    @Query("SELECT * FROM timers WHERE name = :name AND profile = :profileId")
    suspend fun getTimer(name: String, profileId: Int) : Timer

    // insert a Timer with a profile
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTimer(timer: Timer)

    // Update a Timer
    @Update
    suspend fun updateTimer(timer: Timer)

    // Delete a Timer
    @Delete
    suspend fun deleteTimer(timer: Timer)
}