package com.matheusxreis.todo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.matheusxreis.todo.R
import com.matheusxreis.todo.api.FakeApi
import com.matheusxreis.todo.repository.NoteRepository
import com.matheusxreis.todo.viewmodel.note.NoteViewModel
import com.matheusxreis.todo.viewmodel.note.NoteViewModelFactory

class MainActivity : AppCompatActivity() {

    //referente a injeção de dependencia
     lateinit var mainViewModel: NoteViewModel;
     val fakeApi = FakeApi();


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        instanceViewModel()
        observeViewModel()
    }


    fun instanceViewModel(){
        //

        //injeção feita, View Model criado
        mainViewModel = ViewModelProvider(
            this,
            NoteViewModelFactory(
                NoteRepository(
                    fakeApi
                )
            )
        ).get(NoteViewModel::class.java)
    }

    fun observeViewModel(){

        mainViewModel.noteLiveData.observe(this)
            {
                Toast.makeText(this, "The list has changed!", Toast.LENGTH_LONG).show()
            }


         mainViewModel.error.observe(this) {
            if (it === true) {
                Toast.makeText(this, "Please, put at least a title.", Toast.LENGTH_LONG).show()
            }
        }
    }


}