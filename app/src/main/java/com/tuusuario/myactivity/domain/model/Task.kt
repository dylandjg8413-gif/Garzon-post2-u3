package com.tuusuario.myactivity.domain.model

data class Task(
    val id: Long,
    val title: String,
    val completed: Boolean = false
)
