package com.example.reference.di.data.mapper

import com.example.reference.domain.Task
import com.example.reference.di.data.local.TaskEntity

fun Task.toEntity() = TaskEntity(
    id = id,
    title = title,
    completed = completed
)

fun TaskEntity.toDomain() = Task(
    id = id,
    title = title,
    completed = completed
)