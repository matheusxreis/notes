package com.matheusxreis.todo.model

import java.util.*

data class Task(
    val title:String,
    val createdAt: Date = Calendar.getInstance().time,
    val description:String,
    val done: Boolean = false,
    val id: String
    )
