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

    fun listAll(){
        fakeApi.listAll()
    }

    fun addNewTask(note: Note){
      fakeApi.addNewTask(note)
    }

    fun removeTask(id: String){
       fakeApi.removeTask(id)
    }

}