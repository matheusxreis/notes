package com.matheusxreis.todo.viewmodel.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.matheusxreis.todo.repository.NoteRepository
import java.lang.IllegalArgumentException

class MainViewModelFactory(
    val repository: NoteRepository
): ViewModelProvider.Factory{


    override fun <T: ViewModel>create(modelClass: Class<T>):T{
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            MainViewModel(this.repository) as T
        }else {
            throw IllegalArgumentException("ViewModel Not Found")
        }

    }
}