package com.example.reference.di.data.repository

import androidx.paging.PagingSource
import com.example.reference.di.data.local.TaskEntity
import com.example.reference.domain.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getTasks(): Flow<List<Task>>
    suspend fun refreshTasks() // <--- ADD THIS LINE
    fun getTasksPagingSource(): PagingSource<Int, TaskEntity>

}