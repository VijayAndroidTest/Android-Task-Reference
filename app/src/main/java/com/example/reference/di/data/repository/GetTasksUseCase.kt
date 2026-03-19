package com.example.reference.di.data.repository

import com.example.reference.di.data.repository.TaskRepository
import javax.inject.Inject

class GetTasksUseCase  @Inject constructor(
    private val repository: TaskRepository
) {
     operator fun invoke() = repository.getTasks()
}