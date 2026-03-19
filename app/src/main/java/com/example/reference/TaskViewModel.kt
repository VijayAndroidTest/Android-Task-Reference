package com.example.reference

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reference.domain.Task
import com.example.reference.di.data.repository.GetTasksUseCase
import com.example.reference.di.data.repository.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val useCase: GetTasksUseCase,
    private val repository: TaskRepository
) : ViewModel() {

    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks = _tasks

    // 1. Add this to track loading state
    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing = _isRefreshing

    init {
        loadTasks()
        refreshData() // Initial fetch
    }

    private fun loadTasks() {
        viewModelScope.launch {
            useCase().collect { _tasks.value = it }
        }
    }

    // 2. Rename this to match the UI call: refreshData()
    fun refreshData() {
        viewModelScope.launch {
            _isRefreshing.value = true
            try {
                repository.refreshTasks()
            } catch (e: Exception) {
                // Handle error
            } finally {
                _isRefreshing.value = false
            }
        }
    }
}