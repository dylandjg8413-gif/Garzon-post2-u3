package com.tuusuario.myactivity.domain

interface TaskRepository {
    suspend fun getAllTasks(): List<Task>
    suspend fun addTask(title: String)

}
