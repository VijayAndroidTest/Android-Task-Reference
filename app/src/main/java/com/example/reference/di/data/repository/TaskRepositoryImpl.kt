package com.example.reference.di.data.repository

import com.example.reference.domain.Task
import com.example.reference.di.data.local.TaskDao
import com.example.reference.di.data.mapper.toDomain
import com.example.reference.di.data.mapper.toEntity
import com.example.reference.di.data.remote.TaskApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(
    private val api: TaskApi,
    private val dao: TaskDao
) : TaskRepository {

    override fun getTasks(): Flow<List<Task>> {
        return dao.getTasks()
            .map { list ->
                list.map { it.toDomain() }
            }
    }

   override suspend fun refreshTasks() {
        val remote = api.getTasks()
        remote.forEach {
            dao.insertTask(it.toEntity()) // ✅ FIXED
        }
    }
}