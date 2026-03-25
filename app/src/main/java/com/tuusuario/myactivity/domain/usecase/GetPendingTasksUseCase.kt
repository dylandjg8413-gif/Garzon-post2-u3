package com.tuusuario.myactivity.domain.usecase

import com.tuusuario.myactivity.domain.model.Task
import com.tuusuario.myactivity.domain.repository.TaskRepository

class GetPendingTasksUseCase(private val repository: TaskRepository) {
    suspend operator fun invoke(): List<Task> {
        return repository.getAllTasks()
            .filter { !it.completed } // Solo tareas pendientes
            .sortedByDescending { it.id } // Más recientes primero
    }
}
