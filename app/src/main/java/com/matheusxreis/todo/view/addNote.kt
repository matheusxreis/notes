package com.matheusxreis.todo.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import com.matheusxreis.todo.R
import com.matheusxreis.todo.model.Note
import com.matheusxreis.todo.viewmodel.note.NoteViewModel

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
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null



    val model: NoteViewModel by activityViewModels<NoteViewModel>();


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState);

        val button = view.findViewById<Button>(R.id.buttonadd)

        button.setOnClickListener{
            model.addNewNote(
                Note("É foda!")
            )
        }

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