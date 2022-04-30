package com.matheusxreis.todo.viewmodel.note

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.matheusxreis.todo.repository.NoteRepository
import java.lang.IllegalArgumentException

class NoteViewModelFactory(
    val repository: NoteRepository
): ViewModelProvider.Factory{


    override fun <T: ViewModel>create(modelClass: Class<T>):T{
        return if (modelClass.isAssignableFrom(NoteViewModel::class.java)){
            NoteViewModel(this.repository) as T
        }else {
            throw IllegalArgumentException("ViewModel Not Found")
        }

    }
}