package com.matheusxreis.todo.viewmodel.main

import androidx.lifecycle.ViewModel
import com.matheusxreis.todo.model.Note
import com.matheusxreis.todo.repository.NoteRepository

class MainViewModel(
    private val noteRepository: NoteRepository,
):ViewModel() {
//a regra de negócio acontece aqui
    
    fun listAll (): List<Note> = noteRepository.listAll();


    fun addNewNote(note: Note){
        if(note.title.isNotEmpty()){
            noteRepository.addNewNote(note)
        }

    }

    fun removeNote(id: String){
        if(id.isNotEmpty()){
            noteRepository.removeNote(id)
        }
    }

}