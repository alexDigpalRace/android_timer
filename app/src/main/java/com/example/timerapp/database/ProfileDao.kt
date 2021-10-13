package com.example.timerapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfileDao {

    @Query("SELECT * FROM profiles WHERE id = :id")
    suspend fun getProfile(id: Int) : Profile

    @Query("SELECT * FROM profiles")
    fun getProfiles() : Flow<List<Profile>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProfile(profile : Profile)
}
