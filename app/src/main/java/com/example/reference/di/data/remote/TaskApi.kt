package com.example.reference.di.data.remote

import com.example.reference.domain.Task
import retrofit2.http.GET

interface TaskApi {
    @GET("todos")
    suspend fun getTasks(): List<Task>
}