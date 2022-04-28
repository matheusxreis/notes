package com.matheusxreis.todo.model

import java.util.*

data class Note(
    val title:String,
    val createdAt: Date? = Calendar.getInstance().time,
    val description:String? = "Sem descrição",
    val done: Boolean? = false,
    val id: String? =" ahashuass"
    )
