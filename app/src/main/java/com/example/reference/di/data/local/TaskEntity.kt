package com.example.reference.di.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TaskEntity")
data class TaskEntity(@PrimaryKey val id: Int,
                      val title: String,
                      val completed: Boolean)