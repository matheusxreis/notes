package com.matheusxreis.todo.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.matheusxreis.todo.R
import com.matheusxreis.todo.model.Note
import org.w3c.dom.Text

class NoteAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var notes: List<Note> = listOf();

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_holder,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is NoteViewHolder -> {
                holder.bind(notes[position])
            }
        }
    }

    override fun getItemCount(): Int = notes.size

    fun setItems(data: List<Note>){
        notes = data;
    }


    inner class NoteViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val title = itemView.findViewById<TextView>(R.id.rv_title)
        val date = itemView.findViewById<TextView>(R.id.rv_date)


        fun bind(note: Note){
            title.text = note.title;
            date.text = note.createdAt.toString()


        }
    }
}
