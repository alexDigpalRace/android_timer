package com.example.timerapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "profiles")
data class Profile (
    @PrimaryKey(autoGenerate = true) val id : Int,
    val name: String
): Parcelable