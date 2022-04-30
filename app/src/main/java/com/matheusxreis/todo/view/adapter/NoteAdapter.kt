package com.matheusxreis.todo.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.matheusxreis.todo.R
import com.matheusxreis.todo.model.Note

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

        private val title = itemView.findViewById<TextView>(R.id.rv_title)
        private val date = itemView.findViewById<TextView>(R.id.rv_date)
        private val statusImportant = itemView.findViewById<MaterialButton>(R.id.rv_status_important)


        @SuppressLint("ResourceAsColor")
        fun bind(note: Note){
            title.text = note.title;
            date.text = note.createdAt.toString();
            println(note.important)

            statusImportant.setBackgroundColor(ContextCompat.getColor(
                itemView.context,
               getColor(note)))
        }


        private fun getColor(note:Note):Int{
                if(note.important){

                    return R.color.urgent

                }
                return R.color.easy
        }
    }
}
