package com.example.timerapp.database

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfileDao {

    @Query("SELECT * FROM profiles WHERE id = :id")
    suspend fun getProfile(id: Int) : Profile

    @Query("SELECT * FROM profiles")
    fun getProfiles() : LiveData<List<Profile>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProfile(profile : Profile)

    @Update
    suspend fun updateProfile(profile: Profile)

    @Delete
    suspend fun deleteProfile(profile: Profile)
}
