package com.example.jotitdown

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class DialogShowNote : DialogFragment () {

    private var note: Note? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //all other code goes here
        val builder = AlertDialog.Builder(this.requireActivity())

        val inflater = requireActivity().layoutInflater

        val dialogView = inflater.inflate(R.layout.dialog_show_note, null)

        val txtTitle = dialogView.findViewById<TextView>(R.id.txtTitle)

        val txtDescription = dialogView.findViewById<TextView>(R.id.txtDescription)

        txtTitle.text = note!!.title
        txtDescription.text = note!!.description

        val txtImportant = dialogView.findViewById<TextView>(R.id.textViewImportant)

        val txtTodo = dialogView.findViewById<TextView>(R.id.textViewTodo)

        val txtIdea = dialogView.findViewById<TextView>(R.id.textViewIdea)

        if (!note!!.important) {
            txtImportant.visibility = View.GONE
        }

        if (!note!!.todo) {
            txtTodo.visibility = View.GONE
        }

        if (!note!!.idea) {
            txtIdea.visibility = View.GONE
        }

        val btnOK = dialogView.findViewById<Button>(R.id.btnOK)

        builder.setView(dialogView).setMessage("Your Note")

        btnOK.setOnClickListener {
            dismiss()
        }

        return builder.create()
    }

    //receive a note from the MainActivity class
    fun sendNoteSelected(noteSelected: Note) {
        note = noteSelected
    }
}