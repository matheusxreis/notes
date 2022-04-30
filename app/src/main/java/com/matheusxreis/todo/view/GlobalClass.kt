package com.matheusxreis.todo.view

import android.app.Application
import com.matheusxreis.todo.model.Note

class GlobalClass:Application(){

    var notes: List<Note> = listOf()

}