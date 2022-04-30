package com.matheusxreis.todo.view

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import com.google.android.material.button.MaterialButton
import com.matheusxreis.todo.R
import com.matheusxreis.todo.model.Note
import org.w3c.dom.Text

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NotePage.newInstance] factory method to
 * create an instance of this fragment.
 */
class NotePage : Fragment(R.layout.fragment_note_page) {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val bundle:Bundle? = this.arguments
        val note = bundle?.get("note")

        val title = view.findViewById<TextView>(R.id.tit)
        val description = view.findViewById<TextView>(R.id.desc)
        val statusImportant = view.findViewById<MaterialButton>(R.id.impr)
        var backButton = view.findViewById<ImageButton>(R.id.backic)

        handleClickBackButton(view, backButton)

        if(note is Note){
            title.text = note.title;
            description.text = note.description;

            statusImportant.setBackgroundColor(
                ContextCompat.getColor(
                view.context,
                getColor(note)))
        }



    }

    fun handleClickBackButton(view: View, button: ImageButton){
        button.setOnClickListener {
            backHome(view)
        }
    }
    fun backHome(view: View){
        Navigation.findNavController(view).navigate(R.id.action_notePage_to_homeTasks)
    }

    private fun getColor(note:Note):Int{
        if(note.important){

            return R.color.urgent

        }
        return R.color.easy
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NotePage.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NotePage().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}