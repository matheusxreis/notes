package com.matheusxreis.todo.viewmodel.note

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.matheusxreis.todo.model.Note
import com.matheusxreis.todo.repository.NoteRepository
/*
Os LiveData são como os estados no React.
São os dados observados que devem ser atualizados.
O livedata respeita o ciclo de vida da sua Activity.
*/
class NoteViewModel(
    private val noteRepository: NoteRepository,
):ViewModel() {
//a regra de negócio acontece aqui

    val noteLiveData = MutableLiveData<List<Note>>()

    val error = MutableLiveData<Boolean>()

    fun listAll (): List<Note> = noteRepository.listAll();


    fun addNewNote(note: Note){
        if(note.title.isNotEmpty()){
            noteRepository.addNewNote(note)

            noteLiveData.postValue(noteRepository.listAll())
            error.postValue(false)
        }else {
            error.postValue(true)
        }



    }

    fun removeNote(id: String){
        if(id.isNotEmpty() && noteRepository.listAll().isNotEmpty()){
            noteRepository.removeNote(id)

            noteLiveData.postValue(noteRepository.listAll())
        }
    }

}