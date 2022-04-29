package com.matheusxreis.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.matheusxreis.todo.adapter.NoteAdapter
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

    //adapter
    lateinit var noteAdapter: NoteAdapter;




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

        initRecyclerView()
        setDataIntoRv()

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

    fun initRecyclerView(){
        this.noteAdapter = NoteAdapter();

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.apply{
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = noteAdapter
        }
    }

    fun setDataIntoRv(){

        val a: List<Note> = listOf(
            Note("Lavar a louça"),
            Note("Oh, a vida"),
            Note("Tomar o remédio")
        )
        noteAdapter.setItems(a)
    }

}