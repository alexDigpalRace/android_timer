package com.example.timerapp.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "timers")
data class Timer (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    @ColumnInfo(name="profile") val profile_id: Int,
    val hours: Int,
    val minutes: Int,
    val seconds: Int

) : Parcelable