package com.matheusxreis.todo.repository

import com.matheusxreis.todo.api.FakeApi
import com.matheusxreis.todo.model.Note

/*
* Repositório é uma interface de consulta e manipulação ESPECÍFICA
* em coleções de dados, independente da sua origem.
* */
class NoteRepository(
    private val fakeApi: FakeApi
){

    fun listAll(): List<Note>{
       return fakeApi.listAll()
    }

    fun addNewNote(note: Note){
      fakeApi.addNewNote(note)
    }

    fun removeNote(id: String){
       fakeApi.removeNote(id)
    }

}