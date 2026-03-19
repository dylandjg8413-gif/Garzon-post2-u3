package com.tuusuario.myactivity.presentation

import com.tuusuario.myactivity.data.FakeTaskRepository
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

    private lateinit var fakeRepo: FakeTaskRepository
    private lateinit var viewModel: TaskViewModel

    @Before
    fun setUp() {
        fakeRepo = FakeTaskRepository()
        viewModel = TaskViewModel(fakeRepo)
    }

    @Test
    fun `carga de tareas produce estado Success con datos del repositorio`() = runTest {
        viewModel.loadTasks()
        val state = viewModel.uiState.value
        assertTrue(state is TaskUiState.Success)
        assertEquals(4, (state as TaskUiState.Success).tasks.size)
    }
}
