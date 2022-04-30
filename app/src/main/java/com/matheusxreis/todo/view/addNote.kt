package com.matheusxreis.todo.view

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.matheusxreis.todo.R
import com.matheusxreis.todo.model.Note
import com.matheusxreis.todo.viewmodel.note.NoteViewModel
import kotlinx.coroutines.delay
import org.w3c.dom.Text
import java.lang.reflect.Type

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [addTask.newInstance] factory method to
 * create an instance of this fragment.
 */
class addNote : Fragment(R.layout.fragment_add_task) {




    val model: NoteViewModel by activityViewModels<NoteViewModel>();
    var priority:Boolean = false;



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState);


        val backButton = view.findViewById<ImageView>(R.id.backicon)



        handleClickBackButton(view, backButton)
        changePriority(view)
        addNewTask(view)



    }


    fun handleClickBackButton(view: View, button: ImageView){
        button.setOnClickListener {
            backHome(view)
        }
    }

    fun backHome(view: View){
       Navigation.findNavController(view).navigate(R.id.action_addTask_to_homeTasks)
    }

     fun addNewTask(view: View){

        val addButton = view.findViewById<FloatingActionButton>(R.id.add_new_note)
        val titleNote = view.findViewById<TextView>(R.id.input_title)
        val descriptionNote = view.findViewById<TextView>(R.id.input_description)

        addButton.setOnClickListener {
            model.addNewNote(
                Note(
                    title = titleNote.text.toString(),
                    description = descriptionNote.text.toString(),
                    important = priority
                )
            )

            println(priority)
            this.backHome(view)
        }
    }

    fun changePriority(view:View){
        val priorityUrgentButton = view.findViewById<MaterialButton>(R.id.urgent_button)

        val priorityEasyButton = view.findViewById<MaterialButton>(R.id.easy_button)

        priorityUrgentButton.setOnClickListener {
            priorityUrgentButton.setStrokeColorResource(R.color.primary)
            priorityUrgentButton.setBackgroundColor(ContextCompat.getColor(priorityUrgentButton.context,
                                                                            R.color.urgentSelected))
            priorityEasyButton.setStrokeColorResource(android.R.color.transparent)
            priorityEasyButton.setBackgroundColor(ContextCompat.getColor(priorityEasyButton.context,
                R.color.easy))

            priority = true;
            println(priority)

        }

        priorityEasyButton.setOnClickListener {
            priorityEasyButton.setStrokeColorResource(R.color.primary)
            priorityEasyButton.setBackgroundColor(ContextCompat.getColor(priorityEasyButton.context,
                                                                    R.color.easySelected))
            priorityUrgentButton.setStrokeColorResource(android.R.color.transparent)
            priorityUrgentButton.setBackgroundColor(ContextCompat.getColor(priorityUrgentButton.context,
                R.color.urgent))

            priority = false;
            println(priority)
        }
    }


    fun verifyError(view: View){
        if(model.error.value === false) backHome(view)
    }





    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment addTask.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            addNote().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}