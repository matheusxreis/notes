package com.matheusxreis.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.matheusxreis.todo.api.FakeApi
import com.matheusxreis.todo.model.Note
import com.matheusxreis.todo.repository.NoteRepository
import com.matheusxreis.todo.viewmodel.main.MainViewModel
import com.matheusxreis.todo.viewmodel.main.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    //referente a injeção de dependencia
    lateinit var mainViewModel: MainViewModel;
    lateinit var noteRepository: NoteRepository;
    val fakeApi = FakeApi();




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //




        //injeção feita, View Model criado
        mainViewModel = ViewModelProvider(
                this,
                MainViewModelFactory(
                    NoteRepository(
                        fakeApi
                    )
                )
            ).get(MainViewModel::class.java)

        var a = 1;

    }




    override fun onStart(){
        super.onStart()

        //No código abaixo eu estou observando o .noteLiveData
        //assim, toda vez que ela mudar (Dentro do meu ViewModel,
        // através do postValue),
        //minha callback pode fazer alguma coisa


        mainViewModel.noteLiveData.observe(this,
            {})




    }
}