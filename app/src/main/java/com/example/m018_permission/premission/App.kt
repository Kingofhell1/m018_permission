package com.example.m018_permission.premission

import android.app.Application
import androidx.room.Room
import com.example.m018_permission.data.AppDatabase
import com.example.m018_permission.data.PhotoDao

class App : Application() {
    lateinit var photoDatabase: AppDatabase

    override fun onCreate() {
        super.onCreate()

        photoDatabase = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "photoDatabase"
        ).build()
    }
}