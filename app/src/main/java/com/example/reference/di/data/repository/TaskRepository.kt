package com.example.reference.di.data.repository

import com.example.reference.domain.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getTasks(): Flow<List<Task>>
    suspend fun refreshTasks() // <--- ADD THIS LINE
}