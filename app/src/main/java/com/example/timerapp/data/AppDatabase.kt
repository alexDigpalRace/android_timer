package com.example.timerapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.timerapp.dao.ProfileDao
import com.example.timerapp.dao.TimerDao
import com.example.timerapp.model.Profile
import com.example.timerapp.model.Timer

@Database(entities = [Profile::class, Timer::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun profileDao(): ProfileDao
    abstract fun timerDao(): TimerDao

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized (this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}