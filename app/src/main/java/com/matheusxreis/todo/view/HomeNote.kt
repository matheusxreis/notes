package com.matheusxreis.todo.view

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.ItemTouchHelper
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

        }
    }

    fun initRecyclerView(view: View){
        this.noteAdapter = NoteAdapter{
            this.handleGoToNotePage(it)
        };

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)

        ItemTouchHelper(MySimpleCallback()).attachToRecyclerView(recyclerView)
        recyclerView.apply{
            layoutManager = LinearLayoutManager(this@HomeNote.requireContext())
            adapter = noteAdapter
        }
    }

    fun setDataIntoRv(){

        val b = model.listAll();
        noteAdapter.setItems(b);
        noteAdapter.notifyDataSetChanged();
    }

    fun handleGoToNotePage(note:Note?){

        val bundleArgs = bundleOf("note" to note)
        Navigation.findNavController(this@HomeNote.requireView()).navigate(R.id.action_homeTasks_to_notePage, args=bundleArgs);

    }


    inner class MySimpleCallback: ItemTouchHelper.SimpleCallback(
        ItemTouchHelper.DOWN or ItemTouchHelper.UP,
        ItemTouchHelper.RIGHT){
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {

            val startPosition = viewHolder.adapterPosition
            val endPosition = target.adapterPosition

            recyclerView.adapter?.notifyItemMoved(startPosition, endPosition)

            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
           val idNote = noteAdapter.notes[viewHolder.adapterPosition].id
            if(idNote is String){
                model.removeNote(idNote)
                Toast.makeText(this@HomeNote.context, "The note was deleted!", Toast.LENGTH_SHORT).show()
            }

          setDataIntoRv()
        }

        override fun isLongPressDragEnabled(): Boolean {
            return super.isLongPressDragEnabled()
        }

        override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {

            if(actionState === ItemTouchHelper.ACTION_STATE_DRAG){

                println("ARRASTOU")
                viewHolder?.itemView?.setBackgroundColor(
                    ContextCompat.getColor(
                        viewHolder.itemView.context,
                        R.color.black
                    )
                )
            }

            super.onSelectedChanged(viewHolder, actionState)
        }


    }


}