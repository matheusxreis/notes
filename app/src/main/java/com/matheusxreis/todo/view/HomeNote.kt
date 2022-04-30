package com.matheusxreis.todo.view

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.matheusxreis.todo.R
import com.matheusxreis.todo.view.adapter.NoteAdapter
import com.matheusxreis.todo.model.Note
import com.matheusxreis.todo.viewmodel.note.NoteViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class HomeNote : Fragment(R.layout.fragment_home_tasks) {

    //adapter
    lateinit var noteAdapter: NoteAdapter;
    val model: NoteViewModel by activityViewModels<NoteViewModel>();
    //

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // private val model: SharedViewModel by activityViewModels()

        val notesList = requireArguments().get("NOTES");
        initRecyclerView(view)
        setDataIntoRv()



        val floatButton = view.findViewById<FloatingActionButton>(R.id.fab)


        floatButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeTasks_to_addTask);
            Log.d(null, notesList.toString())
        }
    }

    fun initRecyclerView(view: View){
        this.noteAdapter = NoteAdapter();

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.apply{
            layoutManager = LinearLayoutManager(this@HomeNote.requireContext())
            adapter = noteAdapter
        }
    }

    fun setDataIntoRv(){

        val a: List<Note> = listOf(
            Note("Lavar a louça"),
            Note("Oh, a vida"),
            Note("Tomar o remédio"),
            Note("Lavar a louça"),
            Note("Oh, a vida"),
            Note("Tomar o remédio"),
            Note("Lavar a louça"),
            Note("Oh, a vida"),
            Note("Tomar o remédio")
        )

        val b = model.listAll();
        noteAdapter.setItems(b);

    }

}