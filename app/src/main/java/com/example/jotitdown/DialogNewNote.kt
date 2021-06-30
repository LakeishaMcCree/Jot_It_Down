package com.example.jotitdown

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.DialogFragment

class DialogNewNote : DialogFragment () {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(requireActivity())

        val inflater = requireActivity().layoutInflater

        val dialogView = inflater.inflate(R.layout.dialog_new_note, null)

        val editTitle = dialogView.findViewById<EditText>(R.id.editTitle)

        val editDescription = dialogView.findViewById<EditText>(R.id.editDescription)

        val checkBoxIdea = dialogView.findViewById<CheckBox>(R.id.checkBoxIdea)

        val checkBoxTodo = dialogView.findViewById<CheckBox>(R.id.checkBoxTodo)

        val checkBoxImportant = dialogView.findViewById<CheckBox>(R.id.checkBoxImportant)

        val btnCancel = dialogView.findViewById<Button>(R.id.btnCancel)

        val btnOK = dialogView.findViewById<Button>(R.id.btnOK)

        builder.setView(dialogView).setMessage("Add a new note!")

        //handle the cancel button
        btnCancel.setOnClickListener {
            dismiss()
        }

        btnOK.setOnClickListener {
            //create a new note
            val newNote = Note()

            //set its properties to match the user's entries on the form
            newNote.title = editTitle.text.toString()

            newNote.description = editDescription.text.toString()

            newNote.idea = checkBoxIdea.isChecked
            newNote.todo = checkBoxTodo.isChecked
            newNote.important = checkBoxImportant.isChecked

            //get a reference to MainActivity
            val callingActivity = activity as MainActivity?

            //pass the newNote back to MainActivity
            callingActivity!!.createNewNote(newNote)

            //quit the dialog
            dismiss()
        }

        return builder.create()

    }
}