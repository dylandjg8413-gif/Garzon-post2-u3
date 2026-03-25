package com.tuusuario.myactivity.domain.repository

import com.tuusuario.myactivity.domain.model.Task

interface TaskRepository {
    suspend fun getAllTasks(): List<Task>
    suspend fun addTask(title: String)
}
