package com.example.reference.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.reference.di.data.local.TaskEntity
import com.example.reference.di.data.repository.GetTasksUseCase
import com.example.reference.di.data.repository.TaskRepository
import com.example.reference.domain.Task
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.reference.di.data.mapper.toDomain
@HiltViewModel
class TaskViewModel @Inject constructor(
    private val repository: TaskRepository
) : ViewModel() {

    // 1. PagingData replaces the simple List<Task>
    // stateIn makes this a hot Flow that survives rotations
// Specify <Int, TaskEntity> for the Pager
    val taskPagingData: Flow<PagingData<Task>> = Pager(
        config = PagingConfig(pageSize = 20),
        pagingSourceFactory = { repository.getTasksPagingSource() } // Returns PagingSource<Int, TaskEntity>
    ).flow
        .map { pagingData: PagingData<TaskEntity> ->
            pagingData.map { entity: TaskEntity ->
                entity.toDomain()
            }
        }
        .cachedIn(viewModelScope)

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing = _isRefreshing.asStateFlow()

    fun refreshData() {
        viewModelScope.launch {
            _isRefreshing.value = true
            try {
                repository.refreshTasks()
            } catch (e: Exception) {
                // Log error
            } finally {
                _isRefreshing.value = false
            }
        }
    }
}