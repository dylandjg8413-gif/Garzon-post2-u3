package com.tuusuario.myactivity.di

import com.tuusuario.myactivity.data.repository.InMemoryTaskRepository
import com.tuusuario.myactivity.domain.repository.TaskRepository
import com.tuusuario.myactivity.domain.usecase.GetPendingTasksUseCase
import com.tuusuario.myactivity.presentation.viewmodel.TaskViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // Repositorio: instancia única en toda la aplicación
    single<TaskRepository> { InMemoryTaskRepository() }
    
    // Use Case: nueva instancia por solicitud (sin estado)
    factory { GetPendingTasksUseCase(get()) } // get() inyecta TaskRepository
    
    // ViewModel: scoped al ciclo de vida del ViewModel
    viewModel { TaskViewModel(get()) } // get() inyecta GetPendingTasksUseCase
}
