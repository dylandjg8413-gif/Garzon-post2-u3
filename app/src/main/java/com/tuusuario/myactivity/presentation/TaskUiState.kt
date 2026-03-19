package com.tuusuario.myactivity.presentation

import com.tuusuario.myactivity.domain.Task
sealed class TaskUiState {
    object Loading : TaskUiState()
    data class Success(val tasks: List<Task>) : TaskUiState()
    data class Error(val message: String) : TaskUiState()
}
