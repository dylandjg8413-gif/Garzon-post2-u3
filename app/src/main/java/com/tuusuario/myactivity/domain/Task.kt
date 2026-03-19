package com.tuusuario.myactivity.domain

data class Task(
    val id: Long,
    val title: String,
    val completed: Boolean = false
)
