package com.example.reference.di.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.reference.di.data.local.TaskDao
import com.example.reference.di.data.local.TaskEntity

@Database(entities = [TaskEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}