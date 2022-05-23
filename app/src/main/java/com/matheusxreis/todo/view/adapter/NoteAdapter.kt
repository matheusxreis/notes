package com.matheusxreis.todo.view.adapter

import android.annotation.SuppressLint
import android.view.DragEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.matheusxreis.todo.R
import com.matheusxreis.todo.model.Note
import java.text.SimpleDateFormat

class NoteAdapter(val onClick: (note: Note)->Unit?): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var notes: List<Note> = listOf(); private set

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
        when (holder) {
            is NoteViewHolder -> {
                holder.bind(notes[position])
            }
        }
    }

    override fun getItemCount(): Int = notes.size

    fun setItems(data: List<Note>) {
        notes = data;
    }


    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val title = itemView.findViewById<TextView>(R.id.rv_title)
        private val date = itemView.findViewById<TextView>(R.id.rv_date)
        private val statusImportant =
            itemView.findViewById<MaterialButton>(R.id.rv_status_important)
        private val background = itemView.findViewById<ConstraintLayout>(R.id.rv_background)

        fun getColor(note: Note): Int {
            if (note.important) {

                return R.color.urgent

            }
            return R.color.easy
        }

        fun bind(note: Note) {

            val formattedDate = SimpleDateFormat("dd/MM/yyyy").format(note.createdAt)
            title.text = note.title;
            date.text = "Criado em $formattedDate."
            println(note.important)

            statusImportant.setBackgroundColor(
                ContextCompat.getColor(
                    itemView.context,
                    getColor(note)
                )
            )


            itemView.setOnClickListener {
                onClick(note)
            }

            itemView.setOnDragListener { v, e ->
                when (e.action) {
                    DragEvent.ACTION_DRAG_STARTED -> {
                        v.setBackgroundColor(
                            ContextCompat.getColor(
                                itemView.context,
                                R.color.primary
                            )
                        )
                        true
                    }
                    DragEvent.ACTION_DRAG_ENDED -> {
                        v.setBackgroundColor(
                            ContextCompat.getColor(
                                itemView.context,
                                R.color.white
                            )
                        )

                        true
                    }
                    else -> {
                        false
                    }

                }


            }


        }


    }


}


