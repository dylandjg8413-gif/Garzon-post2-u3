package com.tuusuario.myactivity.presentation

import com.tuusuario.myactivity.domain.model.Task
import com.tuusuario.myactivity.domain.repository.TaskRepository
import com.tuusuario.myactivity.domain.usecase.GetPendingTasksUseCase
import com.tuusuario.myactivity.presentation.viewmodel.TaskViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class TaskViewModelTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var useCase: GetPendingTasksUseCase
    private lateinit var viewModel: TaskViewModel

    private class FakeRepo : TaskRepository {
        override suspend fun getAllTasks() = listOf(
            Task(1, "Task 1"),
            Task(2, "Task 2"),
            Task(3, "Task 3"),
            Task(4, "Task 4", completed = true)
        )
        override suspend fun addTask(title: String) {}
    }

    @Before
    fun setUp() {
        useCase = GetPendingTasksUseCase(FakeRepo())
        viewModel = TaskViewModel(useCase)
    }

    @Test
    fun `carga de tareas produce estado Success con datos del repositorio`() = runTest {
        viewModel.loadTasks()
        val state = viewModel.uiState.value
        assertTrue(state is TaskUiState.Success)
        // El UseCase filtra las completadas, quedan 3 de 4
        assertEquals(3, (state as TaskUiState.Success).tasks.size)
    }
}
