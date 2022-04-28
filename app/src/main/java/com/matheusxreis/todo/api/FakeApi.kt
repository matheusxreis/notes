package com.matheusxreis.todo.api

import com.matheusxreis.todo.model.Note

class FakeApi {

    private var notes: List<Note> = listOf()

    fun listAll(): List<Note> = notes;

    fun addNewTask(note: Note){
        notes = notes.plus(note)
    }

    fun removeTask(id: String){
        val newList = notes.filter {
            it.id !== id
        }
        notes = newList
    }

}